package homeworks.dmytro_m.hw_2023.hw_18_01.truck;

import homeworks.dmytro_m.hw_2023.hw_18_01.enums.ColorCar;

public class RoadTrains extends Truck{



    {
        this.setWheels(18);
        this.setCountFuel(60);
    }

    public RoadTrains(ColorCar color) {
        super(color);
    }


}
