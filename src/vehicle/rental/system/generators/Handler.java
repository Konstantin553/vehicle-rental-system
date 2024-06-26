package vehicle.rental.system.generators;

import vehicle.rental.system.rental.Vehicle;

import java.math.BigDecimal;

public interface Handler {

    BigDecimal getDailyRentalCost(final Vehicle vehicle, final int rentalDays );
    BigDecimal getDailyInsuranceCost(final Vehicle vehicle);
}
