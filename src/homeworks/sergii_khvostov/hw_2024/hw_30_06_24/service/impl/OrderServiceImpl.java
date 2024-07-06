package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.impl;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.OrderDAO;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Order;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.OrderService;
import lombok.RequiredArgsConstructor;


import java.util.List;


@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderDAO ORDER_DAO;

    @Override
    public void addOrder(Order order) {
        ORDER_DAO.add(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return ORDER_DAO.getAll();
    }

    @Override
    public Order getOrderById(int id) {
        return ORDER_DAO.getById(id);
    }

    @Override
    public void updateOrder(Order order) {
        ORDER_DAO.update(order);
    }

    @Override
    public void deleteOrder(int id) {
        ORDER_DAO.delete(id);
    }
}
