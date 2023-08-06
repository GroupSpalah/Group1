package homeworks.dmytro_m.hw_2023.hw_18_01.bus;

import homeworks.dmytro_m.hw_2023.hw_18_01.Car;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.ColorCar;

public abstract class Bus extends Car {

    {
        this.setWheels(4);
        this.setCountFuel(20);
    }

    public Bus(ColorCar color) {
        super(color);
    }



}
