package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.service.impl;

import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.DriverDao;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.Driver;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.Truck;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.service.DriverService;

import java.util.List;

public class DriverServiceImpl implements DriverService {

    private DriverDao dao;

    @Override
    public List<Truck> getTrucksForDriver(int driverId) {
        return dao.getTrucksForDriver(driverId);
    }

    @Override
    public void add(Driver driver) {
        dao.add(driver);
    }

    @Override
    public void update(Driver driver) {
        dao.update(driver);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Driver> getAll() {
        return dao.getAll();
    }

    @Override
    public Driver getById(int id) {
        return dao.getById(id);
    }
}
