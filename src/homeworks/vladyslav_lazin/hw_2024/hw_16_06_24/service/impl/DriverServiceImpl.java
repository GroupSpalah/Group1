package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service.impl;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.DriverDao;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.impl.DriverDaoImpl;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Driver;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service.DriverService;

public class DriverServiceImpl implements DriverService {
    DriverDao driverDAO;

    public DriverServiceImpl() {
        this.driverDAO = new DriverDaoImpl();
    }

    @Override
    public void save(Driver driver) {
        driverDAO.save(driver);
    }

    public void setTruckToDriverById(int driverId, int truckId) {
        driverDAO.setTruckToDriverById(driverId, truckId);
    }

    @Override
    public Driver findById(int id) {
        return driverDAO.findById(id);
    }

    // @Override
    // public void update(Driver driver) {
    // driverDAO.update(driver);
    // }
    //
    // @Override
    // public void deleteById(int id) {
    // driverDAO.deleteById(id);
    // }
    //

    //
    // @Override
    // public List<Driver> findAll() {
    // return driverDAO.findAll();
    // }
}
