package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.util.Date;

public class Tram extends Vehicles {
    private int yearsInService;

    public Tram(int id, String licensePlate, int maxPassengers, String status, String fuelType,
                Date lastMaintenanceDate, int yearsInService) {
        super(id, licensePlate, maxPassengers, status, fuelType, lastMaintenanceDate);
        this.yearsInService = yearsInService;
    }

    public int getYearsInService() {
        return yearsInService;
    }

    public void setYearsInService(int yearsInService) {
        this.yearsInService = yearsInService;
    }
}
