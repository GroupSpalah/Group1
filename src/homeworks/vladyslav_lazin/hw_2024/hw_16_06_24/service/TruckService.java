package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Truck;

public interface TruckService {
    void save(Truck truck);

    Truck findById(int id);
}
