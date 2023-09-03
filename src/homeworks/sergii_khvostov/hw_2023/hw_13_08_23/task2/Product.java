package homeworks.sergii_khvostov.hw_2023.hw_13_08_23.task2;


public class Product {
    private String name;
    private String productionDate;
    private Manufacturer manufacturer;
    private boolean fragility;
    private double price;

    public Product(String name, String productionDate, Manufacturer manufacturer,
                   boolean fragility, double price) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.fragility = fragility;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public boolean isFragility() {
        return fragility;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Manufacturer: " + manufacturer.getName() + ", Fragile: " + isFragility() + ", Price: " + price;
    }

}
