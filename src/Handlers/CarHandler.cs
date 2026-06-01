using VehicleRentalSystem.Rental;
using VehicleRentalSystem.VehicleType;

namespace VehicleRentalSystem.Handlers;

public class CarHandler : IHandler
{
    private const decimal DailyInsuranceVehiclePercent = 0.0001m;
    private const decimal HighSafetyDiscount = 0.9m;
    private const int WeekDays = 7;
    private const int LowSafetyMaxCategory = 4;
    private const decimal DailyRentalCostMoreThan7Days = 15.00m;
    private const decimal DailyRentalCostUpTo7Days = 20.00m;

    private CarHandler() { }

    public static CarHandler GetInstance() => new();

    public decimal GetDailyRentalCost(Vehicle vehicle, int rentalDays) =>
        rentalDays > WeekDays ? DailyRentalCostMoreThan7Days : DailyRentalCostUpTo7Days;

    public decimal GetDailyInsuranceCost(Vehicle vehicle)
    {
        var car = (Car)vehicle;
        var baseCost = DailyInsuranceVehiclePercent * vehicle.Value;
        return car.SafetyRating >= LowSafetyMaxCategory ? baseCost * HighSafetyDiscount : baseCost;
    }
}
