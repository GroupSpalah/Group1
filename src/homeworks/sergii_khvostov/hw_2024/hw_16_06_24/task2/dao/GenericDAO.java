package homeworks.sergii_khvostov.hw_2024.hw_16_06_24.task2.dao;

import java.util.List;

public interface GenericDAO<T> {
    void add(T entity);

    T getById(int id);

    List<T> getAll();

    void deleteById(int id);

    void deleteAll();

    void update(int id, T entity);
}
