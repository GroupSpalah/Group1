package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.time.LocalDate;


public class Tram extends Vehicle {
    private int yearsInService;

    public Tram(int id, String licensePlate, int maxPassengers, String status,
                LocalDate lastMaintenanceDate, FuelType fuelTypes, int yearsInService) {
        super(id, licensePlate, maxPassengers, status, lastMaintenanceDate, fuelTypes);
        this.yearsInService = yearsInService;
    }

    public int getYearsInService() {
        return yearsInService;
    }

    public void setYearsInService(int yearsInService) {
        this.yearsInService = yearsInService;
    }
}
