package vehicle.rental.system.vehicleType;

import vehicle.rental.system.rental.Vehicle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CargoVan extends Vehicle {

    private final int driverExperience;

    public CargoVan(String brand, String model, BigDecimal value, int driverExperience) {
        super(brand, model, value, "cargoVan");
        this.driverExperience = driverExperience;
    }

    public int getDriverExperience() {
        return driverExperience;
    }

    public void displayInfo(){
        System.out.println("\nA cargo van valued at $" + getValue().setScale(2, RoundingMode.DOWN) + " and the driver has "  + driverExperience + "  years of experience\n");
    }
}
