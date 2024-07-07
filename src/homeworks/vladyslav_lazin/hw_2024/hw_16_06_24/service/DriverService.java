package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Driver;

public interface DriverService extends CrudService<Driver> {

    void setTruckToDriverById(int driverId, int truckId);
}
