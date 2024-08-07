package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao;

import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain.Order;

public interface OrderDao extends CrudDao<Order> {
    void addProductToOrder(int orderId, int productId);
    void deleteProductFromOrder(int orderId, int productId);
}
