package homeworks.vladyslav_lazin.hw_2023.hw_10_09_23;

import java.time.LocalDate;

public class Trolleybus extends Vehicle {

    public Trolleybus(String licensePlate, int capacity, LocalDate lastService) {
        super(licensePlate, capacity, lastService);
        this.setFuelType(FuelType.HYBRID);
        this.setCondition(Condition.IN_OPERATION);
    }
}
