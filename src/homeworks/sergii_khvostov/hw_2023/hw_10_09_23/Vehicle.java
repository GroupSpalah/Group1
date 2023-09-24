package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Vehicle {
    private int id;
    private String licensePlate;
    private int maxPassengers;
    private String status;
    private LocalDate lastMaintenanceDate;
    private FuelType fuelTypes;

    private static int counterIds = 1;

    public static final String IN_OPERATION = "in operation";
    public static final String NEEDS_RENOVATION = "needs renovation";
    public static final String SCRAP = "scrap";

    public Vehicle(int id, String licensePlate, int maxPassengers, String status,
                   LocalDate lastMaintenanceDate, FuelType fuelTypes) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.maxPassengers = maxPassengers;
        this.status = status;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.fuelTypes = fuelTypes;
    }

    public Vehicle(String licensePlate, int maxPassengers, String status,
                   LocalDate lastMaintenanceDate, FuelType fuelTypes) {
        this.id = counterIds++;
        this.licensePlate = licensePlate;
        this.maxPassengers = maxPassengers;
        this.status = status;
        this.lastMaintenanceDate = lastMaintenanceDate;
        this.fuelTypes = fuelTypes;
    }

    /* private static LocalDate parseDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateString, formatter);
    }*/

    public int getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public String getStatus() {
        return status;
    }


    public LocalDate getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public FuelType getFuelTypes() {
        return fuelTypes;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public void updateStatus() {
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(lastMaintenanceDate, currentDate);

        int months = period.getMonths();

        if (months >= 0 && months <= 6) {
            status = IN_OPERATION;
        } else if (months >= 7 && months <= 36) {
            status = NEEDS_RENOVATION;
        } else {
            status = SCRAP;
        }
    }
}




