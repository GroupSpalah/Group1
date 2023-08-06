package homeworks.dmytro_k.hw_2023.hw_18_01_23.task2;

public class VehiclesTest {
    public static void main(String[] args) {

        Vehicles vehicles1 = new ElectricCar(4);
        System.out.println(vehicles1.getWheels());
        vehicles1.refuel(Fuel.DIESEL);

        HybridCar hybridCar = new HybridCar(Fuel.ELECTRICITY, Fuel.GASOLINE, 5);
        hybridCar.refuel(Fuel.GASOLINE);
        System.out.println(hybridCar.getWheels());

        Bus bus = new GasolineBus(6, 30); //?
        bus.accelerate();
        bus.brake();

        Vehicles vehicles5 = new DieselBus(6, 45);
        vehicles5.refuel(Fuel.ELECTRICITY);

        ElectricCar electricCar = new ElectricCar(4);
        electricCar.accelerate();
    }
}
