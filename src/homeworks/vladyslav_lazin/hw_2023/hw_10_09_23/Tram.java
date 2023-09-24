package homeworks.vladyslav_lazin.hw_2023.hw_10_09_23;

import java.time.LocalDate;

public class Tram extends Vehicle{
    int timeInOperation;
    public Tram(String licensePlate, int capacity, LocalDate lastService, int timeInOperation) {
        super(licensePlate, capacity, lastService);
        this.setFuelType(FuelType.ELECTRIC);
        this.timeInOperation = timeInOperation;
        this.setCondition(Condition.IN_OPERATION);

    }
}
