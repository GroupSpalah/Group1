package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    int id;
    int orderNumber;
    Map<Product, Integer> products;
    LocalDate receiptDate;
}
