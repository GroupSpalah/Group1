package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Order {
     int id;
     String orderNumber;
     LocalDate orderDate;
     Map<Product, Integer> products = new HashMap<>();

    public Order(String orderNumber, LocalDate orderDate) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
    }

    public void addProduct(Product product, int quantity) {
        products.put(product, quantity);
    }
}
