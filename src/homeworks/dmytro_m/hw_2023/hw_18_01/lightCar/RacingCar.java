package homeworks.dmytro_m.hw_2023.hw_18_01.lightCar;

import homeworks.dmytro_m.hw_2023.hw_18_01.enums.ColorCar;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.Fuel;

public class RacingCar extends PassengerCar{

    {
        this.setFuel(Fuel.PETROL);
    }

    public RacingCar(ColorCar color) {
        super(color);
    }

    @Override
    public void refuelCar(Fuel fuel, double fuels) {
        if (Fuel.PETROL.equals(fuel)) {
            fuels += this.getCountFuel();
            this.setCountFuel(fuels);
            System.out.println("Refueling per " + fuels + " liter");
        } else {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Error");
            }
        }

    }
}
