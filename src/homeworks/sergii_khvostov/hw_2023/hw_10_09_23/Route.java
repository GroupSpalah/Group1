package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.util.List;

public class Route {
    private List<Station> stations;
    private List<Vehicle> vehicles;

    public Route(List<Station> stations, List<Vehicle> vehicles) {
        this.stations = stations;
        this.vehicles = vehicles;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}

