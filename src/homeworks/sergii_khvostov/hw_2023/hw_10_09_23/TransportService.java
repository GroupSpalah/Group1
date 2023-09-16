package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.util.*;


public class TransportService {
    private List<Vehicles> vehicles;
    private List<Route> routes;

    public TransportService(List<Vehicles> vehicles, List<Route> routes) {
        this.vehicles = vehicles;
        this.routes = routes;
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicles> vehicles) {
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


    public void assignRouteToVehicle(Vehicles vehicle, Route route) {
        if (vehicle.getStatus().equalsIgnoreCase("in operation")) {
            route.getVehicles().add(vehicle);
        }
    }

}

