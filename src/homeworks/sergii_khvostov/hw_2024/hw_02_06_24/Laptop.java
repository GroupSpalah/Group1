package homeworks.sergii_khvostov.hw_2024.hw_02_06_24;

import java.time.LocalDate;
import java.util.Date;

public class Laptop {
    private String model;
    private String manufacturer;
    private LocalDate releaseDate;
    private int ramSize;
    private int ssdCapacity;
    private String processor;
    private int id;

    public Laptop(int id, String model, String manufacturer, LocalDate releaseDate,
                  int ramSize, int ssdCapacity, String processor) {
        this.id = id;
        this.model = model;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
        this.ramSize = ramSize;
        this.ssdCapacity = ssdCapacity;
        this.processor = processor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getSsdCapacity() {
        return ssdCapacity;
    }

    public void setSsdCapacity(int ssdCapacity) {
        this.ssdCapacity = ssdCapacity;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void displayInfo() {
        System.out.println("Laptop ID: " + id);
        System.out.println("Model: " + model);
        System.out.println("Manufacturer: " + manufacturer);
        System.out.println("Release Date: " + releaseDate);
        System.out.println("RAM Size: " + ramSize + " GB");
        System.out.println("SSD Capacity: " + ssdCapacity + " GB");
        System.out.println("Processor: " + processor);
    }
}

