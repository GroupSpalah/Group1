package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.service.impl;

import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao_driver.DriverDAO;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.domain.Driver;
import homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.service.DriverService;

import java.util.List;

public class DriverServiceImpl implements DriverService {

    private final DriverDAO driverDAO;

    public DriverServiceImpl(DriverDAO driverDAO) {
        this.driverDAO = driverDAO;
    }

    @Override
    public void addDriver(Driver driver) {
        driverDAO.add(driver);
    }

    @Override
    public Driver getDriverById(int id) {
        return driverDAO.getById(id);
    }

    @Override
    public List<Driver> getAllDrivers() {
        return driverDAO.getAll();
    }

    @Override
    public void deleteDriverById(int id) {
        driverDAO.deleteById(id);
    }

    @Override
    public void deleteAllDrivers() {
        driverDAO.deleteAll();
    }

    @Override
    public void updateDriver(int id, Driver newDriver) {
        driverDAO.update(id, newDriver);
    }
}
