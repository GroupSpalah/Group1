package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task4;

public class Truck extends Car {

    double weight;

    public Truck(double carPrice, String color, double weight) {
        super(carPrice, color);
        this.weight = weight;
    }

    @Override
    double calculateSalePrice() {

        if (weight > 2000) {
            carPrice = carPrice - (carPrice * 0.10);
        } else {
            carPrice = carPrice - (carPrice * 0.20);
        }
        return carPrice;
    }
}
