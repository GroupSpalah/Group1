package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.car;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car("BMW", 140);

        RepresentativeCar representativeCar =
                new RepresentativeCar("Mercedes", 160);

        System.out.println(car.info());
        System.out.println();

        System.out.println(representativeCar.info());
        System.out.println();

        car.updateModel();
        System.out.println(car.info());
        System.out.println();

        representativeCar.updateModel();
        System.out.println(representativeCar.info());
    }
}
