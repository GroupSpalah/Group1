package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.service;

import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.domain.Truck;

import java.util.List;

public interface TruckService {
    void addTruck(Truck truck, int driverId);

    Truck getTruckById(int id);

    List<Truck> getAllTrucks();

    void deleteTruckById(int id);

    void deleteAllTrucks();

    void updateTruck(int id, Truck newTruck);

    List<Truck> getTrucksByDriverId(int driverId);
}
