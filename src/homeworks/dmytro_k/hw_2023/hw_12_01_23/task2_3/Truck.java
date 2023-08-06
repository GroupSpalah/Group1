package homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_3;

public class Truck extends Car {

    private double weight;

    public Truck (double carPrice, String color, double weight) {
        super(carPrice, color);
        this.weight = weight;
    }

    @Override
    public double calculateSalePrice() {
        if (weight > 2000) {
            return super.calculateSalePrice() * 0.9;
        }
            return super.calculateSalePrice() * 0.8;
    }
}
