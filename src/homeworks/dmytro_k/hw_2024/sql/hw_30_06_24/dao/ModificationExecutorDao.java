package homeworks.dmytro_k.hw_2024.sql.hw_30_06_24.dao;


public interface ModificationExecutorDao {
    void createOrderFromToday();

    void deleteOrdersByProductQuantity(int id, int quantity);
}
