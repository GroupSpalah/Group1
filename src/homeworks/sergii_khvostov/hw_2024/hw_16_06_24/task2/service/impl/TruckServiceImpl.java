package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.service.impl;

import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao_truck.TruckDAO;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.domain.Truck;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.service.TruckService;


import java.util.List;

public class TruckServiceImpl implements TruckService {

    private final TruckDAO truckDAO;//mysql, oracle

    public TruckServiceImpl(TruckDAO truckDAO) {
        this.truckDAO = truckDAO;
    }

    @Override
    public void addTruck(Truck truck, int driverId) {
        truckDAO.add(truck);
    }

    @Override
    public Truck getTruckById(int id) {
        return truckDAO.getById(id);
    }

    @Override
    public List<Truck> getAllTrucks() {
        return truckDAO.getAll();
    }

    @Override
    public void deleteTruckById(int id) {
        truckDAO.deleteById(id);
    }

    @Override
    public void deleteAllTrucks() {
        truckDAO.deleteAll();
    }

    @Override
    public void updateTruck(int id, Truck newTruck) {
        truckDAO.update(id, newTruck);
    }

    @Override
    public List<Truck> getTrucksByDriverId(int driverId) {
        return truckDAO.getTrucksByDriverId(driverId);
    }
}
