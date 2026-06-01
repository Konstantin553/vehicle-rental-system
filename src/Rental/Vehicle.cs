namespace VehicleRentalSystem.Rental;

public class Vehicle
{
    public string Brand { get; }
    public string Model { get; }
    public decimal Value { get; }
    public string Type { get; }

    public Vehicle(string brand, string model, decimal value, string type)
    {
        Brand = brand;
        Model = model;
        Value = value;
        Type = type;
    }
}
