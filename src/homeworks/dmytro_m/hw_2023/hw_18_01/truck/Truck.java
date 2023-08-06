package homeworks.dmytro_m.hw_2023.hw_18_01.truck;

import homeworks.dmytro_m.hw_2023.hw_18_01.Car;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.ColorCar;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.Fuel;

public abstract class Truck extends Car {

    {
        this.setFuel(Fuel.DIESEL);
    }

    public Truck(ColorCar color) {
        super(color);
    }

    @Override
    public void refuelCar(Fuel fuel, double fuels) {
        if(Fuel.DIESEL.equals(fuel)) {
            fuels += this.getCountFuel();
            this.setCountFuel(fuels);
            System.out.println("Refueling per " + fuels +  " liter");
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

    }
}
