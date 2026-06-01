using VehicleRentalSystem.Rental;

namespace VehicleRentalSystem.Handlers;

public interface IHandler
{
    decimal GetDailyRentalCost(Vehicle vehicle, int rentalDays);
    decimal GetDailyInsuranceCost(Vehicle vehicle);
}
