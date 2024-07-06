package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    List<Order> getAllOrders();

    Order getOrderById(int id);

    void updateOrder(Order order);

    void deleteOrder(int id);
}
