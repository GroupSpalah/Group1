package homeworks.dmytro_k.hw_2023.hw_18_01_23.task2;

public abstract class Bus extends Vehicles {

    private int amountSeats;

    public Bus(Fuel fuel1, int wheels, int amountSeats) {
        super(fuel1, wheels);
        this.amountSeats = amountSeats;
    }

    public void refuel(Fuel fuel) {
        boolean fuelType = fuel.equals(getFuel1());

        System.out.println(fuelType ? "the car is filled" : "wrong type of fuel\n" +
                "car is broken");
    }
}
