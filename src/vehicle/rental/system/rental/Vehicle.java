package vehicle.rental.system.rental;

import java.math.BigDecimal;

public class Vehicle {
    private final String brand;
    private final String model;
    private final BigDecimal value;
    private final String type;

    public Vehicle(String brand, String model, BigDecimal value, String type) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

}

