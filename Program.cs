using VehicleRentalSystem.Invoice;
using VehicleRentalSystem.Rental;
using VehicleRentalSystem.VehicleType;

var printer          = InvoicePrinter.GetInstance();
var invoiceGenerator = InvoiceGenerator.GetInstance();

// --- Car ---
var car = new Car("Opel", "Astra", 15_000.00m, safetyRating: 3);
car.DisplayInfo();
var carOrder   = new RentalOrder("John Doe", car,
    new DateOnly(2024, 6, 3), new DateOnly(2024, 6, 13), new DateOnly(2024, 6, 13));
var carInvoice = invoiceGenerator.Generate(carOrder);
printer.PrintInvoice(carInvoice);

// --- Motorcycle ---
var motorcycle = new Motorcycle("Ducati", "SuperSport 950", 100_000.00m, riderAge: 20);
motorcycle.DisplayInfo();
var motoOrder   = new RentalOrder("Mary Johnson", motorcycle,
    new DateOnly(2024, 6, 3), new DateOnly(2024, 6, 13), new DateOnly(2024, 6, 13));
var motoInvoice = invoiceGenerator.Generate(motoOrder);
printer.PrintInvoice(motoInvoice);

// --- Cargo Van ---
var cargoVan = new CargoVan("Peugeot", "Boxer", 200_000.00m, driverExperience: 20);
cargoVan.DisplayInfo();
var vanOrder   = new RentalOrder("Kyle Brave", cargoVan,
    new DateOnly(2024, 6, 3), new DateOnly(2024, 6, 18), new DateOnly(2024, 6, 13));
var vanInvoice = invoiceGenerator.Generate(vanOrder);
printer.PrintInvoice(vanInvoice);
