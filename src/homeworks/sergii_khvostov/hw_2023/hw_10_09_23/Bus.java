package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.util.Date;

public class Bus extends Vehicle {
    private int pollutionIndicator;

    public Bus(int id, String licensePlate, int maxPassengers, String status, String fuelType,
               Date lastMaintenanceDate, int pollutionIndicator) {
        super(id, licensePlate, maxPassengers, status, fuelType, lastMaintenanceDate);
        this.pollutionIndicator = pollutionIndicator;
    }

    public int getPollutionIndicator() {
        return pollutionIndicator;
    }

    public void setPollutionIndicator(int pollutionIndicator) {
        this.pollutionIndicator = pollutionIndicator;
    }

    @Override
    public void updateStatus() {
        super.updateStatus();

        if (getStatus().equalsIgnoreCase("in operation") && pollutionIndicator > 5) {
            setStatus("in operation (with a high degree of contamination)");
        } else if (getStatus().equalsIgnoreCase("needs renovation") &&
                pollutionIndicator >= 3 && pollutionIndicator <= 5) {
            setStatus("needs renovation (moderate pollution)");
        } else if (getStatus().equalsIgnoreCase("scrapped")) {

        }
    }
}





