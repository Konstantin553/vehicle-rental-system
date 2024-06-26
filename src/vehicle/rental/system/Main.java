package vehicle.rental.system;

import vehicle.rental.system.Invoice.Invoice;
import vehicle.rental.system.Invoice.InvoiceGenerator;
import vehicle.rental.system.Invoice.InvoicePrinter;
import vehicle.rental.system.rental.RentalOrder;
import vehicle.rental.system.vehicleType.Car;
import vehicle.rental.system.vehicleType.CargoVan;
import vehicle.rental.system.vehicleType.Motorcycle;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final InvoicePrinter printer =InvoicePrinter.getInstance();
        final InvoiceGenerator invoiceGenerator = InvoiceGenerator.getInstance();

        final Car car = new Car("Opel", "Astra", new BigDecimal("15000.00"), 3);
        car.displayInfo();
        final RentalOrder carOrder = new RentalOrder("John Doe", car, LocalDate.of(2024, 6, 3), LocalDate.of(2024, 6, 13), LocalDate.of(2024, 6, 13));
        final Invoice carInvoice = invoiceGenerator.generate(carOrder);
        printer.printInvoice(carInvoice);

        final Motorcycle motorcycle = new Motorcycle("Ducati", "SuperSport 950", new BigDecimal("100000.00"), 20);
        motorcycle.displayInfo();
        final RentalOrder motorcycleOrder = new RentalOrder("Mary Johnson", motorcycle, LocalDate.of(2024,6,3), LocalDate.of(2024,6,13), LocalDate.of(2024,6,13));
        final Invoice motorcycleInvoice = invoiceGenerator.generate(motorcycleOrder);
        printer.printInvoice(motorcycleInvoice);

        final CargoVan cargoVan = new CargoVan("Peugeot", "Boxer", new BigDecimal("200000.00"), 20);
        cargoVan.displayInfo();
        final RentalOrder cargoVanOrder = new RentalOrder("Kyle Brave", cargoVan, LocalDate.of(2024,6,3), LocalDate.of(2024,6,18), LocalDate.of(2024,6,13));
        final Invoice cagoVanInvoice = invoiceGenerator.generate(cargoVanOrder);
        printer.printInvoice(cagoVanInvoice);
    }
}