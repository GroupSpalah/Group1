package homeworks.sergii_khvostov.hw_2023.hw_11_06_23.online_shop_new;

import java.util.List;

@FunctionalInterface
public interface BasketCalculator {
    double calculateTotalPrice(List<Product> products);
}
