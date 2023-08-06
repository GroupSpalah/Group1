package homeworks.sergii_khvostov.hw_2023.hw_23_04_23.online_store;

public class Product {
    private final String name;
    private final String manufacturer;
    private final String productDate;
    private final int quantity;
    private final int availableQuantity;


    public Product(String name, String manufacturer, String productDate, int quantity,
                   int availableQuantity) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.productDate = productDate;
        this.quantity = quantity;
        this.availableQuantity = availableQuantity;
    }

    public String getName() {
        return name;
    }


    public String getManufacturer() {
        return manufacturer;
    }


    public String getProductDate() {
        return productDate;
    }


    public int getQuantity() {
        return quantity;
    }


    public boolean checkQuantity(int requestedQuantity) {
        return requestedQuantity <= availableQuantity;
    }
}
