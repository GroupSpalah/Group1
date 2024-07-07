package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    int id;
    String name;
    String description;
    float price;
}
