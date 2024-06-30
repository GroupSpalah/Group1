package homeworks.dmytro_k.hw_2024.sql.hw_16_06_24.service;

import java.util.List;

public interface CrudService<T> {
    void add(T t);

    void update(T t);

    void deleteById(int id);

    List<T> getAll();

    T getById(int id);

}
