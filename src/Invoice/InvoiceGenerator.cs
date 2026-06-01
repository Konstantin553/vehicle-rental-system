using VehicleRentalSystem.Handlers;
using VehicleRentalSystem.Rental;

namespace VehicleRentalSystem.Invoice;

public class InvoiceGenerator
{
    private const decimal FiftyPercentDiscount = 0.5m;

    private readonly Dictionary<string, IHandler> _handlers;

    private InvoiceGenerator(Dictionary<string, IHandler> handlers)
    {
        _handlers = handlers;
    }

    public static InvoiceGenerator GetInstance() => new(new Dictionary<string, IHandler>
    {
        { "car",       CarHandler.GetInstance() },
        { "motorcycle", MotorcycleHandler.GetInstance() },
        { "cargoVan",  CargoVanHandler.GetInstance() }
    });

    public Invoice Generate(RentalOrder rentalOrder)
    {
        long reservedDays = rentalOrder.StartDate.DayNumber - rentalOrder.EndDate.DayNumber;
        reservedDays = Math.Abs(reservedDays);

        long actualDays = Math.Abs(rentalOrder.StartDate.DayNumber - rentalOrder.ActualReturnDate.DayNumber);

        if (!_handlers.TryGetValue(rentalOrder.Vehicle.Type, out var handler))
            throw new InvalidOperationException($"Not supported vehicle type: {rentalOrder.Vehicle.Type}");

        var dailyRentalCost    = handler.GetDailyRentalCost(rentalOrder.Vehicle, (int)reservedDays);
        var dailyInsuranceCost = handler.GetDailyInsuranceCost(rentalOrder.Vehicle);

        var totalRentalCost    = GetTotalRentalCost(rentalOrder, reservedDays, actualDays, dailyRentalCost);
        var totalInsuranceCost = dailyInsuranceCost * actualDays;

        return new Invoice(
            DateOnly.FromDateTime(DateTime.Today),
            rentalOrder.CustomerName,
            rentalOrder.Vehicle.Brand,
            rentalOrder.Vehicle.Model,
            rentalOrder.StartDate,
            rentalOrder.EndDate,
            reservedDays,
            rentalOrder.ActualReturnDate,
            actualDays,
            dailyInsuranceCost,
            dailyRentalCost,
            totalRentalCost,
            totalInsuranceCost
        );
    }

    private static decimal GetTotalRentalCost(RentalOrder order, long reservedDays, long actualDays, decimal dailyRentalCost)
    {
        if (order.ActualReturnDate < order.EndDate)
        {
            long remainingDays = reservedDays - actualDays;
            return dailyRentalCost * (actualDays * (FiftyPercentDiscount * remainingDays));
        }

        return dailyRentalCost * actualDays;
    }
}
