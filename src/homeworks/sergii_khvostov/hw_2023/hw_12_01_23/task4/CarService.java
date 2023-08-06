package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task4;

public class CarService {
    public static void main(String[] args) {
        Truck truck = new Truck(5000, "Red", 2500);
        System.out.println(truck.calculateSalePrice());

        Sedan sedan = new Sedan(3000, "Black", 22);
        System.out.println(sedan.calculateSalePrice());
    }
}
