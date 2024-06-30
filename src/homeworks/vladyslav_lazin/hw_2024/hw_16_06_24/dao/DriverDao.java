package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Driver;

import java.util.List;

public interface DriverDao {
    
    void save(Driver driver);

    void setTruckToDriverById(int driverId, int truckId);
    
    Driver findById(int id);

    List<Driver> findAll();

   


}
