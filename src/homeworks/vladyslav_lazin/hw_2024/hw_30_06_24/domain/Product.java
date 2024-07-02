package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    int id;
    String name;
    String description;
    float price;
}
