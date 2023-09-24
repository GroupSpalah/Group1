package homeworks.dmytro_k.hw_2023.hw_10_09_23;

import java.time.LocalDate;

public class Trolleybus extends Vehicle {
    public Trolleybus(int identifier, String numberplate, int numberOfPassengers, LocalDate serviceDate) {
        super(identifier, numberplate, numberOfPassengers, serviceDate);
        this.setFuelType(Fuel.HYBRID);//super?
        setStatus(serviceDate);
    }
}
