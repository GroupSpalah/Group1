package homeworks.dmytro_m.hw_2023.hw_18_01;

import homeworks.dmytro_m.hw_2023.hw_18_01.bus.Minibus;
import homeworks.dmytro_m.hw_2023.hw_18_01.truck.EuroTrucks;
import homeworks.dmytro_m.hw_2023.hw_18_01.truck.RoadTrains;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.ColorCar;
import homeworks.dmytro_m.hw_2023.hw_18_01.enums.Fuel;
import homeworks.dmytro_m.hw_2023.hw_18_01.lightCar.RacingCar;

public class Test {
    public static void main(String[] args) {

        RacingCar r = new RacingCar(ColorCar.BLACK);
        System.out.println(r.getFuel());
        System.out.println(r.getWheels());
        System.out.println(r.getCountFuel());
        r.refuelCar(Fuel.PETROL, 5);

        Car car = new EuroTrucks(ColorCar.BLACK);
        System.out.println(car);


        Car car1 = new RoadTrains(ColorCar.BLACK);
        System.out.println(car1);

        Minibus car2 = new Minibus(ColorCar.BLACK);

    }
}
//Пожалуйста, моделируйте в домене классов, описанном ниже.
//        Настоятельно рекомендуется использовать интерфейсы, абстрактные классы, наследования и абстрактные методы.
//        Нужны и исключения.
//
//        Транспортные средства. Есть разные транспортные средства - легковые, грузовые, автобусы.
//        Машины тоже могут быть разными - внедорожник, гоночный автомобиль, малолитражка.
//
//        Транспортное средство работает на некотором топливе - бензин, дизель, электричество.
//        Заправить машину можно. Если используется неправильное топливо - машина должна сломаться. (исключение)
//        Все транспортные средства могут выполнять некоторые действия: например, ускоряться или тормозить.
//
//        У каждого автомобиля есть колеса. Но у грузовиков и автобусов больше колес, чем у автомобилей.
//        Должна быть возможность запросить количество колес у автомобиля.