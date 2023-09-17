package homeworks.dmytro_k.hw_2023.hw_10_09_23;

import java.util.List;

/**
 * * Следующий шаг в цифровизации — отслеживание маршрутов. Маршрут описывается двумя или более станциями,
 * * и список транспортных средств, которые на нем работают. Помните, что маршрут может быть назначен
 * * только транспортным средствам, находящимся в эксплуатации.
 * * Каждая станция имеет название.
 */


public class Route {
    private int number;
    private List<String> stations;
    private List<Vehicle> vehicles;

    public Route(int number, List<String> stations, List<Vehicle> vehicles) {
        this.number = number;
        this.stations = stations;
        this.vehicles = vehicles;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
