namespace VehicleRentalSystem.Invoice;

public class InvoicePrinter
{
    private readonly TextWriter _writer;

    private InvoicePrinter(TextWriter writer)
    {
        _writer = writer;
    }

    public static InvoicePrinter GetInstance() => new(Console.Out);

    public void PrintInvoice(Invoice invoice)
    {
        _writer.WriteLine("XXXXXXXXXX");
        _writer.WriteLine($"Date: {invoice.Date}");
        _writer.WriteLine($"Customer Name: {invoice.CustomerName}");
        _writer.WriteLine($"Rented vehicle: {invoice.VehicleBrand} {invoice.VehicleModel}\n");
        _writer.WriteLine($"Reservation start date: {invoice.StartDate}");
        _writer.WriteLine($"Reservation end date: {invoice.EndDate}");
        _writer.WriteLine($"Reserved rental days: {invoice.ReservedDays} days\n");
        _writer.WriteLine($"Actual Return date: {invoice.ActualReturnDate}");
        _writer.WriteLine($"Actual rental days: {invoice.ActualDays} days\n");
        _writer.WriteLine($"Rental cost per day: ${Format(invoice.DailyRentalCost)}");
        _writer.WriteLine($"Insurance per day: ${Format(invoice.DailyInsuranceCost)}");
        _writer.WriteLine($"Total rent: ${Format(invoice.TotalRentalCost)}");
        _writer.WriteLine($"Total insurance: ${Format(invoice.TotalInsuranceCost)}");
        _writer.WriteLine($"Total: ${Format(invoice.TotalInsuranceCost + invoice.TotalRentalCost)}");
        _writer.WriteLine("XXXXXXXXXX");
    }

    private static string Format(decimal value) => Math.Truncate(value * 100) / 100 is var v ? v.ToString("F2") : "0.00";
}
