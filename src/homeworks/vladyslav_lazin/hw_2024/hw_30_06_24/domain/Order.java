package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    int id;
    int orderNumber;
    Map<Product, Integer> products;
    LocalDate receiptDate;
}
