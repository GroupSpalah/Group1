package homeworks.dmytro_k.hw_2023.hw_18_01_23.task2;

public abstract class Truck extends Vehicles {

    private double loadCapacity;

    public Truck(Fuel fuel1, int wheels, double loadCapacity) {
        super(fuel1, wheels);
        this.loadCapacity = loadCapacity;
    }

    public void refuel(Fuel fuel) {
        boolean fuelType = fuel.equals(getFuel1());

        System.out.println(fuelType ? "the car is filled" : "wrong type of fuel\n" +
                "car is broken");
    }
}
