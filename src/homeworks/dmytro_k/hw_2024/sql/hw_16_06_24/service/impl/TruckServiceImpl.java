package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.service.impl;

import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.dao.TruckDao;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.domain.Truck;
import homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.service.TruckService;

import java.util.List;

public class TruckServiceImpl implements TruckService {

    private TruckDao dao;

    @Override
    public void add(Truck truck) {
        dao.add(truck);
    }

    @Override
    public void update(Truck truck) {
        dao.update(truck);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Truck> getAll() {
        return dao.getAll();
    }

    @Override
    public Truck getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Truck> getTrucksByValue(String sqlExpression, int value) {
        return dao.getTrucksByValue(sqlExpression, value);
    }
}
