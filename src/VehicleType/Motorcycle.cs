using VehicleRentalSystem.Rental;

namespace VehicleRentalSystem.VehicleType;

public class Motorcycle : Vehicle
{
    public int RiderAge { get; }

    public Motorcycle(string brand, string model, decimal value, int riderAge)
        : base(brand, model, value, "motorcycle")
    {
        RiderAge = riderAge;
    }

    public void DisplayInfo()
    {
        Console.WriteLine($"\nA motorcycle that is valued at ${Value:F2} and the driver is {RiderAge} years old\n");
    }
}
