using VehicleRentalSystem.Rental;

namespace VehicleRentalSystem.VehicleType;

public class CargoVan : Vehicle
{
    public int DriverExperience { get; }

    public CargoVan(string brand, string model, decimal value, int driverExperience)
        : base(brand, model, value, "cargoVan")
    {
        DriverExperience = driverExperience;
    }

    public void DisplayInfo()
    {
        Console.WriteLine($"\nA cargo van valued at ${Value:F2} and the driver has {DriverExperience} years of experience\n");
    }
}
