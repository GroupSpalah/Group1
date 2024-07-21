package homeworks.sergii_khvostov.hw_2024.hw_30_06_24;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.OrderDAO;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.ProductDAO;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Order;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Product;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.OrderService;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.ProductService;

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
        ProductService productService = new ProductService();
        OrderService orderService = new OrderService();

        Product product1 = new Product("Product 1", "Description 1", new BigDecimal("100.00"));
        Product product2 = new Product("Product 2", "Description 2", new BigDecimal("200.00"));
        productService.createProduct(product1.getName(), product1.getDescription(), product1.getPrice());
        productService.createProduct(product2.getName(), product2.getDescription(), product2.getPrice());

        Map<Product, Integer> products = new HashMap<>();
        products.put(product1, 2);
        products.put(product2, 1);

        orderService.createOrder("Order001", LocalDate.now(), products);
    }
}



