package homeworks.sergii_khvostov.hw_2023.hw_18_01_23.task2;

public class Hybrid extends Car {
    private String fuel;

    public Hybrid(String brand, String model, int productYear,
                  int amountWheels, String fuel) {
        super(brand, model, productYear, amountWheels);
        this.fuel = fuel;
    }


    @Override
    void refuelsCar() {
        if (this.fuel.equalsIgnoreCase("petrol") ||
                this.fuel.equalsIgnoreCase("electricity")) {
            System.out.println("Your car id loaded");
        } else {
            System.out.println("Your car is broken");
        }
    }

    @Override
    public void acceleration() {
        System.out.println("Car is acceleration");
    }

    @Override
    public void deceleration() {
        System.out.println("Car is decelaration");
    }
}
