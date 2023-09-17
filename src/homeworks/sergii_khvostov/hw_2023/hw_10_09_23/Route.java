package homeworks.sergii_khvostov.hw_2023.hw_10_09_23;

import java.util.List;

public class Route {
    private List<Station> stations;
    private List<Vehicles> vehicles;

    public Route(List<Station> stations, List<Vehicles> vehicles) {
        this.stations = stations;
        this.vehicles = vehicles;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }
}

