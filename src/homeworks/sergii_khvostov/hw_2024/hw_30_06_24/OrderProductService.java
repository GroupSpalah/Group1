package homeworks.sergii_khvostov.hw_2024.hw_30_06_24;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.OrderDAO;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.ProductDAO;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Order;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Product;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.OrderService;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.ProductService;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.impl.OrderServiceImpl;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.impl.ProductServiceImpl;
import lombok.Cleanup;
import lombok.SneakyThrows;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProductService {
    @SneakyThrows
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImpl(new OrderDAO());
        ProductService productService = new ProductServiceImpl(new ProductDAO());

        @Cleanup
        // Создание нового заказа
        Order order = new Order("ORD001", LocalDate.now());
        order.addProduct(new Product("Product 1", "Description 1", BigDecimal.valueOf(100)), 2);
        order.addProduct(new Product("Product 2", "Description 2", BigDecimal.valueOf(150)), 1);


        // Добавление заказа и продуктов в базу данных через сервисы
        orderService.addOrder(order);
        for (Product product : order.getProducts().keySet()) {
            productService.addProduct(product);
        }


        // Получение всех заказов
        List<Order> orders = orderService.getAllOrders();
        for (Order o : orders) {
            System.out.println(o);
        }

        // Получение продукта по ID
        Product product = productService.getProductById(1);
        System.out.println("Product: " + product);

        // Обновление заказа
        order.setOrderNumber("ORD002");
        orderService.updateOrder(order);

        // Удаление продукта
        productService.deleteProduct(2);
    }
}



