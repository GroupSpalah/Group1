package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.util.Date;

public class Trolleybus extends Vehicles {
    private boolean hasElectricEngine;

    public Trolleybus(int id, String licensePlate, int maxPassengers, String status,
                      String fuelType, Date lastMaintenanceDate, boolean hasElectricEngine) {
        super(id, licensePlate, maxPassengers, status, fuelType, lastMaintenanceDate);
        this.hasElectricEngine = hasElectricEngine;
    }

    public boolean isHasElectricEngine() {
        return hasElectricEngine;
    }

    public void setHasElectricEngine(boolean hasElectricEngine) {
        this.hasElectricEngine = hasElectricEngine;
    }
}