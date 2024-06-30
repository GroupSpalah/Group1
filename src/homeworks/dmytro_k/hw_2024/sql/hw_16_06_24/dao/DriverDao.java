package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao;

import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.Driver;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.Truck;

import java.util.List;

public interface DriverDao extends CrudDao<Driver> {

    List<Truck> getTrucksForDriver(int driverId);
}
