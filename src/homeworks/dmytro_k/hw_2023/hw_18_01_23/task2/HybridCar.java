package homeworks.dmytro_k.hw_2023.hw_18_01_23.task2;

public class HybridCar extends Car {

    public HybridCar(Fuel fuel1, Fuel fuel2, int wheels) {
        super(fuel1, fuel2, wheels);
    }

    @Override
    public void refuel(Fuel fuel) {
        boolean fuelType = fuel.equals(getFuel1()) || fuel.equals(getFuel2());

        System.out.println(fuelType ? "the car is filled" : "wrong type of fuel\n" +
                "car is broken");
    }
}
