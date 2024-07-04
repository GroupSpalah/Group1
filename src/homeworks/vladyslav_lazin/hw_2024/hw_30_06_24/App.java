package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24;

import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain.Order;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain.Product;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.service.OrderService;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.service.ProductService;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.service.impl.OrderServiceImpl;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.service.impl.ProductServiceImpl;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        ProductService productService = new ProductServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        Product product = Product.builder()
                .name("iPhone 14")
                .description("The newest phone from Apple")
                .price(1499.99F)
                .build();
        Order order = Order.builder()
                .orderNumber(2024070401)
                .receiptDate(LocalDate.of(2024, 07, 03))
                .build();
//        productService.save(product);
        orderService.save(order);
        orderService.addProductToOrder(1, 1);
    }
}
