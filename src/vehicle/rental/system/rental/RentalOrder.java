package vehicle.rental.system.rental;

import java.time.LocalDate;

public record RentalOrder(String customerName,
                          Vehicle vehicle,
                          LocalDate startDate,
                          LocalDate endDate,
                          LocalDate actualReturnDate) {
}
