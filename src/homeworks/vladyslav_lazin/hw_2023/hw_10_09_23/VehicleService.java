package homeworks.vladyslav_lazin.hw_2023.hw_10_09_23;

import java.util.Set;
import java.util.stream.Collectors;

public class VehicleService {

    public static Set<Vehicle> findByCondition(Set<Vehicle> vehicles, Condition condition) {
        return vehicles
                .stream()
                .filter(element -> element.getCondition().equals(condition))
                .collect(Collectors.toSet());
    }

    public static Set<Vehicle> findOnRoute(Set<Vehicle> vehicles, String route) {
        return VehicleService
                .findByCondition(vehicles, Condition.IN_OPERATION)
                .stream()
                .filter(element -> element.getRoute().equals(route))
                .collect(Collectors.toSet());
    }

}
