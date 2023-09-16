package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.util.Date;

public class Vehicles {
    private int id;
    private String licensePlate;
    private int maxPassengers;
    private String status;
    private String fuelType;
    private Date lastMaintenanceDate;

    public Vehicles(int id, String licensePlate, int maxPassengers, String status,
                    String fuelType, Date lastMaintenanceDate) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.maxPassengers = maxPassengers;
        this.status = status;
        this.fuelType = fuelType;
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

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

    public String getFuelType() {
        return fuelType;
    }

    public Date getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public void updateStatus() {
        Date currentDate = new Date();
        long diffInMonths = (currentDate.getTime() - lastMaintenanceDate.getTime())
                / (30L * 24L * 60L * 60L * 1000L);

        if (diffInMonths >= 0 && diffInMonths <= 6) {
            status = "in operation";
        } else if (diffInMonths >= 7 && diffInMonths <= 36) {
            status = "needs renovation";
        } else {
            status = "scrap";
        }
    }
}



