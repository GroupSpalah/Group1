package homeworks.dmytro_k.hw_2024.sql.hw_02_06_24;

import java.time.LocalDate;

public class Laptop {
    private int id;
    private String model;
    private String manufacturer;
    private LocalDate releaseDate;
    private int RAMCapacity;
    private int SSDCapacity;
    private String processor;

    public Laptop(String model, String manufacturer, LocalDate releaseDate,
                  int RAMCapacity, int SSDCapacity, String processor) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
        this.RAMCapacity = RAMCapacity;
        this.SSDCapacity = SSDCapacity;
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

    public int getRAMCapacity() {
        return RAMCapacity;
    }

    public int getSSDCapacity() {
        return SSDCapacity;
    }

    public String getProcessor() {
        return processor;
    }

    @Override
    public String toString() {
        return
                "| id=" + id +
                " | model='" + model + '\'' +
                " | manufacturer='" + manufacturer + '\'' +
                " | releaseDate='" + releaseDate + '\'' +
                " | RAMCapacity=" + RAMCapacity +
                " | SSDCapacity=" + SSDCapacity +
                " | processor='" + processor + '\'' +
                " |" +
                "\n------------------------------------------------------------------------------------------------" +
                "------------------------------------------------------------";
    }
}
