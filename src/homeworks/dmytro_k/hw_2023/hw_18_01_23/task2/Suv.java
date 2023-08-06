package homeworks.dmytro_k.hw_2023.hw_18_01_23.task2;

public class Suv extends Car {

    private int clearance;

    public Suv(Fuel fuel1, int wheels, int clearance) {
        super(fuel1, wheels);
        this.clearance = clearance;
    }
}
