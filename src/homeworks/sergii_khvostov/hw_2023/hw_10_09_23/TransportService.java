package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.util.*;


public class TransportService {
    private List<Vehicle> vehicles;
    private List<Route> routes;

    public TransportService(List<Vehicle> vehicles, List<Route> routes) {
        this.vehicles = vehicles;
        this.routes = routes;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }


    public long countVehiclesByTypeAndStatus(String type, String status) {
        return vehicles.stream()
                .filter(vehicle -> vehicle.getClass().getSimpleName().equalsIgnoreCase(type)
                        && vehicle.getStatus().equalsIgnoreCase(status))
                .count();
    }


    public void assignRouteToVehicle(Vehicle vehicle, Route route) {
        if (vehicle.getStatus().equalsIgnoreCase("in operation")) {
            route.getVehicles().add(vehicle);
        }
    }

}

