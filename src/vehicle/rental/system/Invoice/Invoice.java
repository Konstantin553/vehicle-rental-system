package vehicle.rental.system.Invoice;

import java.math.BigDecimal;
import java.time.LocalDate;

public record Invoice(LocalDate date,
                      String customerName,
                      String vehicleBrand,
                      String vehicleModel,
                      LocalDate startDate,
                      LocalDate endDate,
                      long reservedDays,
                      LocalDate actualReturnDate,
                      long actualDays,
                      BigDecimal dailyInsuranceCost,
                      BigDecimal dailyRentalCost,
                      BigDecimal totalRentalCost,
                      BigDecimal totalInsuranceCost
) {
}
