package homeworks.dmytro_m.hw_2022.hw_18_12_2022.Airplane;

public class Airplane {

    private String brand;
    private String model;
    private double maxSpeed;
    private int maxHeight;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public Airplane(String brand, String model, double maxSpeed, int maxHeight) {
        this.brand = brand;
        this.model = model;
        this.maxSpeed = maxSpeed;
        this.maxHeight = maxHeight;
    }


    public double returnPrice() {
        return maxSpeed * 1000 + maxHeight * 100;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", maxHeight=" + maxHeight +
                ", cost=" + returnPrice() + '}';
    }
}
