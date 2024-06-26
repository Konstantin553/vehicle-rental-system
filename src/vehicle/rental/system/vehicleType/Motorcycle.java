package vehicle.rental.system.vehicleType;

import vehicle.rental.system.rental.Vehicle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Motorcycle extends Vehicle {
    private final int riderAge;


    public Motorcycle(String brand, String model, BigDecimal value, int riderAge) {
        super(brand, model, value, "motorcycle");
        this.riderAge = riderAge;
    }

    public int getRiderAge(){return riderAge;}

    public void displayInfo(){
        System.out.println("\nA motorcycle that is valued at $" + getValue().setScale(2, RoundingMode.DOWN) +
                " and the driver is " + riderAge + " years old\n");
    }
}
