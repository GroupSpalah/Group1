package homeworks.sergii_khvostov.hw_2023.hw_11_06_23.online_shop_new;

import java.time.LocalDate;

public class Product {
    private final String NAME;
    private final String MANUFACTURER;
    private final LocalDate PRODUCT_DATE;
    private int quantity;
    private double price;

    public Product(String name, String manufacturer, LocalDate productionDate,
                   int quantity, double price) {
        this.NAME = name;
        this.MANUFACTURER = manufacturer;
        this.PRODUCT_DATE = productionDate;
        this.quantity = quantity;
        this.price = price;
    }

    public String getNAME() {
        return NAME;
    }

    public String getMANUFACTURER() {
        return MANUFACTURER;
    }

    public LocalDate getPRODUCT_DATE() {
        return PRODUCT_DATE;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

