package homeworks.sergii_khvostov.hw_2023.hw_18_01_23.task2;

public class Truck extends Vehicles {
    private int amountWheels;

    public Truck(String brand, String model,
                 int productYear, int amountWheels) {
        super(brand, model, productYear);
        this.amountWheels = amountWheels;
    }

    public int getAmountWheels() {
        return amountWheels;
    }

    @Override
    void refuelsCar() {

    }

    @Override
    public void acceleration() {

    }

    @Override
    public void deceleration() {

    }
}
