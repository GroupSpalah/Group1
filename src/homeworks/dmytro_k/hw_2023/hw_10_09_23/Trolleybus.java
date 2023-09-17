package homeworks.dmytro_k.hw_2023.hw_10_09_23;

import java.time.LocalDate;

public class Trolleybus extends Vehicle {

    public Trolleybus(int identifier, String numberplate, int numberOfPassengers,
                      Fuel fuelType, LocalDate serviceDate) {
        super(identifier, numberplate, numberOfPassengers, fuelType, serviceDate);
        setStatus(serviceDate);
    }
}
