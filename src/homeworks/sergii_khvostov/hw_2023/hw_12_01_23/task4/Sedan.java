package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task4;

public class Sedan extends Car {

    double length;

    public Sedan(double carPrice, String color, double length) {
        super(carPrice, color);
        this.length = length;
    }

    @Override
    double calculateSalePrice() {
        if (length > 20) {
            carPrice = carPrice - (carPrice * 0.05);

        } else {
            carPrice = carPrice - (carPrice * 0.10);
        }
        return carPrice;
    }
}
