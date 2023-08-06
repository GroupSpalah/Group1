package homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_3;

public class Sedan extends Car {

    private double length;

    public Sedan(double carPrice, String color, double length) {
        super(carPrice, color);
        this.length = length;
    }

    @Override
    public double calculateSalePrice() {
        if (length > 20) {
            return super.calculateSalePrice() * 0.95;
        }
            return super.calculateSalePrice() * 0.9;
    }
}
