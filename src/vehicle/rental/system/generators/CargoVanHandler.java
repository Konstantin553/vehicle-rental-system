package vehicle.rental.system.generators;

import vehicle.rental.system.rental.Vehicle;
import vehicle.rental.system.vehicleType.CargoVan;

import java.math.BigDecimal;

public class CargoVanHandler implements Handler {
    private static final BigDecimal DAILY_RENTAL_COST_FOR_MORE_THAN_7_DAYS = new BigDecimal("40.00");
    private static final BigDecimal DAILY_RENTAL_COST_FOR_LESS_THAN_OR_EQUALS_TO_7_DAYS = new BigDecimal("50.00");
    private static final BigDecimal DAILY_INSURANCE_VEHICLE_PERCENT = new BigDecimal("0.0003");
    private static final long WEEK_DAYS = 7;
    private static final BigDecimal  EXPERIENCE_INSURANCE_DECREASE = new BigDecimal("0.85");
    private static final int DRIVER_EXPERIENCE = 5;

    private CargoVanHandler(){

    }

    public static CargoVanHandler getInstance(){
        return new CargoVanHandler();
    }


    @Override
    public BigDecimal getDailyRentalCost(Vehicle vehicle, int rentalDays) {
        return rentalDays > WEEK_DAYS ? DAILY_RENTAL_COST_FOR_MORE_THAN_7_DAYS : DAILY_RENTAL_COST_FOR_LESS_THAN_OR_EQUALS_TO_7_DAYS;
    }

    @Override
    public BigDecimal getDailyInsuranceCost(Vehicle vehicle) {
        final CargoVan cargoVan = (CargoVan) vehicle;
        final BigDecimal baseCost = DAILY_INSURANCE_VEHICLE_PERCENT.multiply(vehicle.getValue());
        return cargoVan.getDriverExperience() > DRIVER_EXPERIENCE ? baseCost.multiply(EXPERIENCE_INSURANCE_DECREASE) : baseCost;
    }
}
