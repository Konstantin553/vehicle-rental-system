package vehicle.rental.system.vehicleType;

import vehicle.rental.system.rental.Vehicle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Car extends Vehicle {

    private final int safetyRating;

    public Car(String brand, String model, BigDecimal value, int safetyRating) {
        super(brand, model, value, "car");
        this.safetyRating = safetyRating;
    }

    public int getSafetyRating(){return safetyRating;}

    public void displayInfo(){
        System.out.println("\nA car that is valued at $" + getValue().setScale(2, RoundingMode.DOWN) + " and has a security rating of " + safetyRating + "\n");
    }
}

