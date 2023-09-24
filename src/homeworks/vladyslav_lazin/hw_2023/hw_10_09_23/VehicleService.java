package homeworks.vladyslav_lazin.hw_2023.hw_10_09_23;

import java.util.Set;
import java.util.stream.Collectors;

public class VehicleService {

    public static Set<Vehicle> findInOperation(Set<Vehicle> vehicles) {
        return vehicles
                .stream()
                .filter(element -> element.getCondition().equals(Condition.IN_OPERATION))
                .collect(Collectors.toSet());
    }
    public static Set<Vehicle> findNeedsRepairs(Set<Vehicle> vehicles) {
        return vehicles
                .stream()
                .filter(element -> element.getCondition().equals(Condition.NEEDS_REPAIRS))
                .collect(Collectors.toSet());
    }
    public static Set<Vehicle> findScrapped(Set<Vehicle> vehicles) {
        return vehicles
                .stream()
                .filter(element -> element.getCondition().equals(Condition.SCRAPPED))
                .collect(Collectors.toSet());
    }

    public static Set<Vehicle> findOnRoute(Set<Vehicle> vehicles, String route) {
        return VehicleService
                .findInOperation(vehicles)
                .stream()
                .filter(element -> element.getRoute().equals(route))
                .collect(Collectors.toSet());
    }

}
