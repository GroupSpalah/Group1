package homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.service;

import homeworks.vladyslav_lazin.hw_2024.hw_16_06_24.model.Truck;

import java.util.List;

public interface CrudService<T> {
    void save(T t);

    T findById(int id);

    List<T> findAll();
}
