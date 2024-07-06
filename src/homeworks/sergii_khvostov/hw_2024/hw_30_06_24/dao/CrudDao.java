package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao;

import java.util.List;

public interface CrudDao<T> {
    void add(T entity);

    List<T> getAll();

    T getById(int id);

    void update(T t);

    void delete(int id);

}
