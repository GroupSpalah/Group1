package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.DAOFactory;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.OrderDAO;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Order;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Product;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class OrderService {
    private final OrderDAO ORDER_DAO = DAOFactory.getOrderDAO();

    public void createOrder(String orderNumber, LocalDate orderDate, Map<Product, Integer> products) {
        Order order = new Order(orderNumber, orderDate);
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            order.addProduct(entry.getKey(), entry.getValue());
        }
        ORDER_DAO.add(order);
    }

    public List<Order> getAllOrders() {
        return ORDER_DAO.getAll();
    }

    public Order getOrderById(int id) {
        return ORDER_DAO.getById(id);
    }

    public void updateOrder(Order order) {
        ORDER_DAO.update(order);
    }

    public void deleteOrder(int id) {
        ORDER_DAO.delete(id);
    }
}
