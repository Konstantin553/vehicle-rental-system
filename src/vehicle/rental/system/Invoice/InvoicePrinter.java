package vehicle.rental.system.Invoice;

import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvoicePrinter {
    private final PrintStream printer;

    private InvoicePrinter(PrintStream printer) {
        this.printer = printer;
    }

    public static InvoicePrinter getInstance() {return new InvoicePrinter(System.out);}

    public void printInvoice(final Invoice invoice) {

        printer.println("XXXXXXXXXX");
        printer.println("Date: " + invoice.date());
        printer.println("Customer Name: " + invoice.customerName());
        printer.println("Rented vehicle: " + invoice.vehicleBrand() + " " + invoice.vehicleModel() + "\n");
        printer.println("Reservation start date: " + invoice.startDate());
        printer.println("Reservation end date: " + invoice.endDate());
        printer.println("Reserved rental days: " + invoice.reservedDays() + " days\n");
        printer.println("Actual Return date: " + invoice.actualReturnDate());
        printer.println("Actual rental days: " + invoice.actualDays() + " days\n");
        printer.println("Rental cost per day: $" + format(invoice.dailyRentalCost()));
        printer.println("Insurance per day: $" + format(invoice.dailyInsuranceCost()));
        printer.println("Total rent: $" + format(invoice.totalRentalCost()));
        printer.println("Total insurance: $" + format(invoice.totalInsuranceCost()));
        printer.println("Total: $" + format(invoice.totalInsuranceCost().add(invoice.totalRentalCost())));
        printer.println("XXXXXXXXXX");
    }
    private static String format(final BigDecimal value) {
        return value.setScale(2, RoundingMode.DOWN).toPlainString();
    }

}
