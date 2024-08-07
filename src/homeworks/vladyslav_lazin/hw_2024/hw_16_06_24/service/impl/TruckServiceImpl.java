package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service.impl;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.TruckDao;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.dao.impl.TruckDaoImpl;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Truck;
import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service.TruckService;

import java.util.List;

public class TruckServiceImpl implements TruckService {
    TruckDao truckDAO;

    public TruckServiceImpl() {
        this.truckDAO = new TruckDaoImpl();
    }

    @Override
    public void save(Truck truck) {
        truckDAO.save(truck);
    }

    @Override
    public Truck findById(int id) {
        return truckDAO.findById(id);
    }

    @Override
    public List<Truck> findAll() {
        return truckDAO.findall();
    }
}
