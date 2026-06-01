namespace VehicleRentalSystem.Invoice;

public record Invoice(
    DateOnly Date,
    string CustomerName,
    string VehicleBrand,
    string VehicleModel,
    DateOnly StartDate,
    DateOnly EndDate,
    long ReservedDays,
    DateOnly ActualReturnDate,
    long ActualDays,
    decimal DailyInsuranceCost,
    decimal DailyRentalCost,
    decimal TotalRentalCost,
    decimal TotalInsuranceCost
);
