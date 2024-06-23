package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Driver;

public interface DriverService {
    public void save(Driver driver);
    
    public void setTruckToDriverById(int driverId, int truckId);

    public Driver findById(int id);

//    public void update(T t);
//
//    public void deleteById(int id);
//
//    
//
//    public List<T> findAll();
}
