package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.service.impl;

import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.OrderDao;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.impl.OrderDaoImpl;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain.Order;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.service.OrderService;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao;

    public OrderServiceImpl() {
        this.orderDao = new OrderDaoImpl();
    }

    @Override
    public void save(Order order) {

    }
}
