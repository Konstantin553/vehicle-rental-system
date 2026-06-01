using VehicleRentalSystem.Rental;

namespace VehicleRentalSystem.VehicleType;

public class Car : Vehicle
{
    public int SafetyRating { get; }

    public Car(string brand, string model, decimal value, int safetyRating)
        : base(brand, model, value, "car")
    {
        SafetyRating = safetyRating;
    }

    public void DisplayInfo()
    {
        Console.WriteLine($"\nA car that is valued at ${Value:F2} and has a security rating of {SafetyRating}\n");
    }
}
