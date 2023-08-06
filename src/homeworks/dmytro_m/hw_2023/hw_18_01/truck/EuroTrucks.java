package homeworks.dmytro_m.hw_2023.hw_18_01.truck;

import homeworks.dmytro_m.hw_2023.hw_18_01.enums.ColorCar;

public class EuroTrucks extends Truck {

    {
        this.setWheels(12);
        this.setCountFuel(40);
    }

    public EuroTrucks(ColorCar color) {
        super(color);
    }

}
