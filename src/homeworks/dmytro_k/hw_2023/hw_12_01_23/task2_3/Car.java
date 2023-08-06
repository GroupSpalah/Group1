package homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_3;

public class Car {

   private double carPrice;
   private String color;

    public Car(double carPrice, String color) {
        this.carPrice = carPrice;
        this.color = color;
    }

    public double calculateSalePrice() {
        return carPrice;
    }
}
