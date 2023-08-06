package homeworks.dmytro_m.hw_2023.hw_18_01.lightCar;

import homeworks.dmytro_m.hw_2023.hw_18_01.Car;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.ColorCar;

public abstract class PassengerCar extends Car {

    {
        this.setWheels(4);
        this.setCountFuel(10);
    }

    public PassengerCar(ColorCar color) {
        super(color);
    }
}