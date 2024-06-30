package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.service;

import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.Truck;

import java.util.List;

public interface TruckService extends CrudService<Truck> {


    List<Truck> getTrucksByValue(String sqlExpression, int value);


}
