package homeworks.dmytro_k.hw_2023.hw_10_09_23;

import java.time.LocalDate;
import java.util.List;

/**
 * Общественный транспорт
 * <p>
 * Наша цель — перестроить и оцифровать систему управления общественным транспортом в нашем городе.
 * <p>
 * Первым шагом является создание инвентаризации всех транспортных средств на складе.
 * Все транспортные средства имеют внутренний уникальный идентификатор, номерной знак, максимальное количество
 * пассажиров, статус (требует ремонта / в эксплуатации / в утиль), тип топлива (электрический, газовый или гибридный)
 * и дату последнего обслуживания. В целом статус дается по времени последнего обслуживания
 * (0-6 месяцев «в эксплуатации», 7-36 «требует ремонта», 37+ «лом»).
 * Каждый тип транспортного средства имеет некоторые дополнительные характеристики:
 * <p>
 * Все автобусы работают на газе и имеют индикатор загрязнения. Автобус находится «в эксплуатации»,
 * если последний срок обслуживания был 0-6 месяцев назад и его показатель загрязнения выше 5;
 * «требует ремонта», если дата обслуживания была 0-12 месяцев назад и показатель загрязнения между
 * 3 и 5, и «в утиль» в противном случае.
 * Троллейбусы имеют как электрический, так и газовый двигатель (гибрид).
 * Все трамваи электрические и хранят количество лет эксплуатации.
 * <p>
 * Первая цель Службы общественного транспорта — выяснить, сколько транспортных средств определенного типа имеют
 * особый статус.
 * <p>
 * Следующий шаг в цифровизации — отслеживание маршрутов. Маршрут описывается двумя или более станциями,
 * и список транспортных средств, которые на нем работают. Помните, что маршрут может быть назначен
 * только транспортным средствам, находящимся в эксплуатации.
 * Каждая станция имеет название.
 */

public class TransportTest {
    public static void main(String[] args) {

        TransportService transportService = new TransportService();

        Bus bus1 = new Bus(1234, "АХ11111ХА", 50,
                LocalDate.of(2023, 9, 23), 6);

        Tram tram1 = new Tram(1235, "АХ22222ХА", 70,
                LocalDate.of(2023, 2, 25), 20);

        Trolleybus trolleybus1 = new Trolleybus(1236, "АХ33333ХА", 55,
                LocalDate.of(2023, 5, 10));

        Trolleybus trolleybus2 = new Trolleybus(1237, "АХ44444ХА", 55,
                LocalDate.of(2023, 9, 24));

        transportService.add(bus1);
        transportService.add(tram1);
        transportService.add(trolleybus1);
        transportService.add(trolleybus2);

        transportService.numberOfVehiclesByStatus(Status.IN_OPERATION);
        transportService.numberOfVehiclesByStatus(Status.NEEDS_REPAIR);
        transportService.numberOfVehiclesByStatus(Status.SCRAPPED);

        List<Vehicle> vehicles = List.of(bus1, tram1, trolleybus1, trolleybus2);
        List<String> stations = List.of("station1", "station2");

        Route route2 = new Route(2, stations, vehicles);

        route2.routInfo();
    }
}
