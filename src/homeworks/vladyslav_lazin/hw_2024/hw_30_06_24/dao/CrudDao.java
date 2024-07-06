package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao;

public interface CrudDao<T> {
    void save(T t);

    T findById(int id);
}
