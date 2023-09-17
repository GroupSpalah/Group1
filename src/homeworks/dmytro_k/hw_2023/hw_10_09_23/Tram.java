package homeworks.dmytro_k.hw_2023.hw_10_09_23;

import java.time.LocalDate;

public class Tram extends Vehicle {

    private int operationYears;

    public Tram(int identifier, String numberplate, int numberOfPassengers,
                Fuel fuelType, LocalDate serviceDate, int operationYears) {
        super(identifier, numberplate, numberOfPassengers, fuelType, serviceDate);
        this.operationYears = operationYears;
        setStatus(serviceDate);
    }
}
