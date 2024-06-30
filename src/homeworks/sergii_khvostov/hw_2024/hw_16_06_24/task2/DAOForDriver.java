package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2;

import java.util.List;

public interface DAOForDriver {
    void addDriver(Driver driver);

    Driver getDriverById(int id);

    List<Driver> getAllDrivers();

    void deleteDriverById(int id);

    void deleteAllDrivers();

    void updateDriver(int id, Driver newDriver);


}
