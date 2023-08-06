package homeworks.dmytro_m.hw_2023.hw_18_01.bus;

import homeworks.dmytro_m.hw_2023.hw_18_01.enums.ColorCar;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.Fuel;

public class BigBus extends Bus {

    private final String[] countPassenger = new String[40];

    {
        this.setFuel(Fuel.DIESEL);
    }

    public BigBus(ColorCar color) {
        super(color);
    }

    public String[] getCountPassenger() {
        return countPassenger;
    }

    @Override
    public void refuelCar(Fuel fuel, double fuels) {
        if (Fuel.DIESEL.equals(fuel)) {
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

    public void choosePlace(String namePassenger) {
        for (int i = 0; i < countPassenger.length; i++) {
            if(countPassenger[i] == null) {
                countPassenger[i] = namePassenger;
            }
        }
    }
}
