package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import java.util.List;

public interface DAODriver {
    void addDriver(Driver driver);

    void updateDriver(Driver driver, int driverId);

    void deleteDriver(int driverId);

    List<Driver> getAllDrivers();

    Driver getDriverById(int driverId);

    List<Truck> getTrucksForDriver(int driverId);
}
