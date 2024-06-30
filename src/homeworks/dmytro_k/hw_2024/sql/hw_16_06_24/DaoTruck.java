package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24;

import java.util.List;

public interface DaoTruck {
    void addTruck(Truck truck);

    void updateTruck(Truck truck, int truckId);

    void deleteTruck(int truckId);

    List<Truck> getAllTrucks();

    List<Truck> getTrucksByValue(String sqlExpression, int value);

    Truck getTruckById(int truckId);
}
