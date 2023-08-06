package homeworks.sergii_khvostov.hw_2023.hw_23_04_23.product_and_price;

import java.util.List;

public class Product {
    private final String name;
    private final List<PriceOfMonth> prices;

    public Product(String name, List<PriceOfMonth> prices) {
        this.name = name;
        this.prices = prices;
    }

    public String getName() {
        return name;
    }

    public int getPrice(String month) {
        for (PriceOfMonth priceOfMonth : prices) {
            if (priceOfMonth.getMonth().equals(month)) {
                return priceOfMonth.getPrice();
            }
        }
        return 0;
    }
}