package homeworks.dmytro_k.hw_2023.hw_10_09_23;

/**
 * Первая цель Службы общественного транспорта — выяснить, сколько транспортных средств определенного типа имеют
 * особый статус.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TransportService {

    private final List<Vehicle> vehicles = new ArrayList<>();
    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void numberOfVehiclesByStatus(Status status) {
        vehicles
                .stream()
                .filter(v -> v.status == status)
                .forEach(System.out::println);
    }
}
