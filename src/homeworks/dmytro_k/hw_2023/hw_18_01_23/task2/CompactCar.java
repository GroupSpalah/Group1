package homeworks.dmytro_k.hw_2023.hw_18_01_23.task2;

public class CompactCar extends Car {

    private double weight;

    public CompactCar(Fuel fuel1, int wheels, double weight) {
        super(fuel1, wheels);
        this.weight = weight;
    }
}
