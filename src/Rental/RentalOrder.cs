namespace VehicleRentalSystem.Rental;

public record RentalOrder(
    string CustomerName,
    Vehicle Vehicle,
    DateOnly StartDate,
    DateOnly EndDate,
    DateOnly ActualReturnDate
);
