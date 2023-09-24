package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.time.LocalDate;


public class Trolleybus extends Vehicle {
    private boolean hasElectricEngine;

    public Trolleybus(int id, String licensePlate, int maxPassengers, String status,
                      LocalDate lastMaintenanceDate, FuelType fuelTypes, boolean hasElectricEngine) {
        super(id, licensePlate, maxPassengers, status, lastMaintenanceDate, fuelTypes);
        this.hasElectricEngine = hasElectricEngine;
    }

    public boolean isHasElectricEngine() {
        return hasElectricEngine;
    }

    public void setHasElectricEngine(boolean hasElectricEngine) {
        this.hasElectricEngine = hasElectricEngine;
    }
}