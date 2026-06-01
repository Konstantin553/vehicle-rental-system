using VehicleRentalSystem.Rental;
using VehicleRentalSystem.VehicleType;

namespace VehicleRentalSystem.Handlers;

public class MotorcycleHandler : IHandler
{
    private const decimal DailyRentalCostMoreThan7Days = 10.00m;
    private const decimal DailyRentalCostUpTo7Days = 15.00m;
    private const decimal DailyInsuranceVehiclePercent = 0.0002m;
    private const int WeekDays = 7;
    private const decimal LowAgeInsuranceIncrease = 1.2m;
    private const int RidersAgeLimit = 25;

    private MotorcycleHandler() { }

    public static MotorcycleHandler GetInstance() => new();

    public decimal GetDailyRentalCost(Vehicle vehicle, int rentalDays) =>
        rentalDays > WeekDays ? DailyRentalCostMoreThan7Days : DailyRentalCostUpTo7Days;

    public decimal GetDailyInsuranceCost(Vehicle vehicle)
    {
        var motorcycle = (Motorcycle)vehicle;
        var baseCost = DailyInsuranceVehiclePercent * vehicle.Value;
        return motorcycle.RiderAge < RidersAgeLimit ? baseCost * LowAgeInsuranceIncrease : baseCost;
    }
}
