package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.service;

public interface CrudService<T> {
    void save(T t);

    T findById(int id);

}
