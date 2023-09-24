package homeworks.dmytro_k.hw_2023.hw_10_09_23;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

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
        long countStations = stations.size();
        if (countStations >= 2) {
            this.stations = stations;
        } else {
            System.out.println("The minimum number of stations for a route is 2.");
        }
        Predicate<Vehicle> vehiclesInOperation = element -> element.status.equals(Status.IN_OPERATION);
        this.vehicles = vehicles
                .stream()
                .filter(vehiclesInOperation)
                .toList();
    }

    public void addStation(String station) {
        stations.add(station);
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle.getStatus().equals(Status.IN_OPERATION)) {
            vehicles.add(vehicle);
        } else {
            System.out.println("The vehicle is not suitable for use");
        }
    }

    public void routInfo() {
        System.out.println(stations.toString());

        Consumer<Vehicle> identifierConsumer = vehicle ->
                System.out.println(vehicle.getClass().getSimpleName()
                        + " Identifier: "
                        + vehicle.getIdentifier()
                        + " " + "Numberplate "
                        + vehicle.getNumberplate());

        vehicles.forEach(identifierConsumer);
    }
}
