package vehicle.rental.system.Invoice;

import vehicle.rental.system.generators.CarHandler;
import vehicle.rental.system.generators.CargoVanHandler;
import vehicle.rental.system.generators.Handler;
import vehicle.rental.system.generators.MotorcycleHandler;
import vehicle.rental.system.rental.RentalOrder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class InvoiceGenerator {
    private static final BigDecimal FIFTY_PERCENT_DISCOUNT = new BigDecimal("0.5");

    private final Map<String, Handler> handlers;

    public InvoiceGenerator(final Map<String, Handler> handlers) {
        this.handlers = handlers;
    }

    public static InvoiceGenerator getInstance(){
        return new InvoiceGenerator(Map.of("car",  CarHandler.getInstance(),
                "motorcycle", MotorcycleHandler.getInstance(),"cargoVan", CargoVanHandler.getInstance()));
    }

    public Invoice generate(final RentalOrder rentalOrder){
        final long reservedDays = ChronoUnit.DAYS.between(rentalOrder.startDate(), rentalOrder.endDate());
        final long actualDays = ChronoUnit.DAYS.between(rentalOrder.startDate(), rentalOrder.actualReturnDate());

        if (handlers.containsKey(rentalOrder.vehicle().getType())) {
            final Handler handler = handlers.get(rentalOrder.vehicle().getType());

            final BigDecimal dailyRentalCost = handler.getDailyRentalCost(rentalOrder.vehicle(), (int)reservedDays);
            final BigDecimal dailyInsuranceCost = handler.getDailyInsuranceCost(rentalOrder.vehicle());

            final BigDecimal totalRentalCost = getTotalRentalCost(rentalOrder, reservedDays, actualDays, dailyRentalCost);
            final BigDecimal totalInsuranceCost =dailyInsuranceCost.multiply(BigDecimal.valueOf(actualDays));

            return new Invoice(LocalDate.now(), rentalOrder.customerName(), rentalOrder.vehicle().getBrand(), rentalOrder.vehicle().getModel(), rentalOrder.startDate(), rentalOrder.endDate(),
                    reservedDays, rentalOrder.actualReturnDate(), actualDays,  dailyRentalCost, dailyInsuranceCost, totalRentalCost, totalInsuranceCost);

        }
        throw new RuntimeException("Not supported vehicle type");
    }

    private BigDecimal getTotalRentalCost(final RentalOrder rentalOrder, final long reservedDays, final long actualDays, final BigDecimal dailyRentalCost){
        if(rentalOrder.actualReturnDate().isBefore(rentalOrder.endDate())){
            long remainingDays = reservedDays - actualDays;

            return dailyRentalCost.multiply(BigDecimal.valueOf(actualDays).multiply(FIFTY_PERCENT_DISCOUNT.multiply(BigDecimal.valueOf(remainingDays))));
        }
        return dailyRentalCost.multiply(BigDecimal.valueOf(actualDays));
    }



}
