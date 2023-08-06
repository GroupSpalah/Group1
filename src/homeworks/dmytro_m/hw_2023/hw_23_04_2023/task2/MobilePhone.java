package homeworks.dmytro_m.hw_2023.hw_23_04_2023.task2;

public class MobilePhone {
    private final String brand;
    private final String phoneModel;
    private final String manufacturer;
    private double price;
    private AccessoriesForGadgets accessories;

    public MobilePhone(String brand, String phoneModel, String manufacturer, double price) {
        this.brand = brand;
        this.phoneModel = phoneModel;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getPhoneModel() {
        return phoneModel;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
