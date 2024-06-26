package vehicle.rental.system.generators;

import vehicle.rental.system.rental.Vehicle;
import vehicle.rental.system.vehicleType.Motorcycle;

import java.math.BigDecimal;

public class MotorcycleHandler implements Handler {

    private static final BigDecimal DAILY_RENTAL_COST_FOR_MORE_THAN_7_DAYS = new BigDecimal("10.00");
    private static final BigDecimal DAILY_RENTAL_COST_FOR_LESS_THAN_OR_EQUALS_TO_7_DAYS = new BigDecimal("15.00");
    private static final BigDecimal DAILY_INSURANCE_VEHICLE_PERCENT = new BigDecimal("0.0002");
    private static final long WEEK_DAYS = 7;
    private static final BigDecimal  LOW_AGE_INSURANCE_INCREASE = new BigDecimal("1.2");
    private static final int RIDERS_AGE_LIMIT = 25;

    private MotorcycleHandler(){

    }

    public static MotorcycleHandler getInstance(){
        return new MotorcycleHandler();
    }


    @Override
    public BigDecimal getDailyRentalCost(Vehicle vehicle, int rentalDays) {
        return rentalDays > WEEK_DAYS ? DAILY_RENTAL_COST_FOR_MORE_THAN_7_DAYS : DAILY_RENTAL_COST_FOR_LESS_THAN_OR_EQUALS_TO_7_DAYS;
    }

    @Override
    public BigDecimal getDailyInsuranceCost(Vehicle vehicle) {
        final Motorcycle motorcycle = (Motorcycle) vehicle;
        final BigDecimal baseCost = DAILY_INSURANCE_VEHICLE_PERCENT.multiply(vehicle.getValue());
        return motorcycle.getRiderAge() < RIDERS_AGE_LIMIT ? baseCost.multiply(LOW_AGE_INSURANCE_INCREASE) : baseCost;
    }

}
