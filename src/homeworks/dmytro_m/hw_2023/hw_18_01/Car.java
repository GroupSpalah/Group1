package homeworks.dmytro_m.hw_2023.hw_18_01;

import homeworks.dmytro_m.hw_2023.hw_18_01.interfaces.Brake;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.ColorCar;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.Fuel;
import homeworks.dmytro_m.hw_2023.hw_18_01.interfaces.Accelerate;
import homeworks.dmytro_m.hw_2023.hw_18_01.interfaces.Refuel;

public abstract class Car implements Brake, Accelerate, Refuel {

    private Fuel fuel;
    private double countFuel;
    private int wheels;
    private ColorCar color;


    public Car(ColorCar color) {
        this.color = color;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public double getCountFuel() {
        return countFuel;
    }

    public void setCountFuel(double countFuel) {
        this.countFuel = countFuel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "fuel=" + fuel +
                ", countFuel=" + countFuel +
                ", wheels=" + wheels +
                ", color=" + color +
                '}';
    }
}
