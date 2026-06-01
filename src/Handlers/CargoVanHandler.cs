using VehicleRentalSystem.Rental;
using VehicleRentalSystem.VehicleType;

namespace VehicleRentalSystem.Handlers;

public class CargoVanHandler : IHandler
{
    private const decimal DailyRentalCostMoreThan7Days = 40.00m;
    private const decimal DailyRentalCostUpTo7Days = 50.00m;
    private const decimal DailyInsuranceVehiclePercent = 0.0003m;
    private const int WeekDays = 7;
    private const decimal ExperienceInsuranceDecrease = 0.85m;
    private const int DriverExperienceThreshold = 5;

    private CargoVanHandler() { }

    public static CargoVanHandler GetInstance() => new();

    public decimal GetDailyRentalCost(Vehicle vehicle, int rentalDays) =>
        rentalDays > WeekDays ? DailyRentalCostMoreThan7Days : DailyRentalCostUpTo7Days;

    public decimal GetDailyInsuranceCost(Vehicle vehicle)
    {
        var cargoVan = (CargoVan)vehicle;
        var baseCost = DailyInsuranceVehiclePercent * vehicle.Value;
        return cargoVan.DriverExperience > DriverExperienceThreshold ? baseCost * ExperienceInsuranceDecrease : baseCost;
    }
}
