package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.time.LocalDate;


public class Bus extends Vehicle {
    private int pollutionIndicator;

    public Bus(int id, String licensePlate, int maxPassengers, String status,
               LocalDate lastMaintenanceDate, int pollutionIndicator, FuelType fuelType) {
        super(id, licensePlate, maxPassengers, status, lastMaintenanceDate, fuelType);
        this.pollutionIndicator = pollutionIndicator;
    }

    public int getPollutionIndicator() {
        return pollutionIndicator;
    }


    @Override
    public void updateStatus() {
        super.updateStatus();

        if (getStatus().equalsIgnoreCase(IN_OPERATION) && pollutionIndicator > 5) {
            setStatus("in operation (with a high degree of contamination)");
        } else if (getStatus().equalsIgnoreCase(NEEDS_RENOVATION) &&
                pollutionIndicator >= 3 && pollutionIndicator <= 5) {
            setStatus("needs renovation (moderate pollution)");
        } else if (getStatus().equalsIgnoreCase(SCRAP)) {

        }
    }
}





