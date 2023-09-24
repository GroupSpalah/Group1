package homeworks.vladyslav_lazin.hw_2023.hw_10_09_23;

import java.time.LocalDate;

public class Vehicle {
    private int id;
    private String licensePlate;
    private int capacity;
    private Condition condition;
    private FuelType fuelType;
    private LocalDate lastService;

    public Vehicle(String licensePlate, int capacity, LocalDate lastService) {
        this.id = (int) (1 + Math.random() * 1000 + System.currentTimeMillis() % 10000);
        this.licensePlate = licensePlate;
        this.capacity = capacity;
        this.lastService = lastService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public LocalDate getLastService() {
        return lastService;
    }

    public void setLastService(LocalDate lastService) {
        this.lastService = lastService;
    }
}
