package homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_3;

public class CarTest {
    public static void main(String[] args) {

        Sedan sedan1 = new Sedan(2000,"red", 21);

        Truck truck1 = new Truck(5000, "white", 2100);

        System.out.println(sedan1.calculateSalePrice());

        System.out.println(truck1.calculateSalePrice());
    }
}
