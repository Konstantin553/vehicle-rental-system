package vehicle.rental.system.generators;

import vehicle.rental.system.rental.Vehicle;
import vehicle.rental.system.vehicleType.Car;

import java.math.BigDecimal;

public class CarHandler implements Handler {


    private static final BigDecimal DAILY_INSURANCE_VEHICLE_PERCENT = new BigDecimal("0.0001");
    private static final BigDecimal HIGH_SAFETY_DISCOUNT = new BigDecimal("0.9");
    private static final long WEEK_DAYS = 7;
    private static final int LOW_SAFETY_MAX_CATEGORY = 4;
    private static final BigDecimal DAILY_RENTAL_COST_FOR_MORE_THAN_7_DAYS = new BigDecimal("15.00");
    private static final BigDecimal DAILY_RENTAL_COST_FOR_LESS_THAN_OR_EQUALS_TO_7_DAYS = new BigDecimal("20.00");

    private CarHandler() {

    }

    public static CarHandler getInstance() {
        return new CarHandler();
    }

    @Override
    public BigDecimal getDailyRentalCost(Vehicle vehicle, int rentalDays) {
        return rentalDays > WEEK_DAYS ? DAILY_RENTAL_COST_FOR_MORE_THAN_7_DAYS : DAILY_RENTAL_COST_FOR_LESS_THAN_OR_EQUALS_TO_7_DAYS;
    }

    @Override
    public BigDecimal getDailyInsuranceCost(Vehicle vehicle) {
        final Car car = (Car) vehicle;
        final BigDecimal baseCost = DAILY_INSURANCE_VEHICLE_PERCENT.multiply(vehicle.getValue());
        return car.getSafetyRating() >= LOW_SAFETY_MAX_CATEGORY ? baseCost.multiply(HIGH_SAFETY_DISCOUNT) : baseCost;
    }
}
