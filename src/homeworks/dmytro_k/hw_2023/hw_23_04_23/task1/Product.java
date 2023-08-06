package homeworks.dmytro_k.hw_2023.hw_23_04_23.task1;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private List<MonthPrice> prices;

    public Product(String name) {
        this.name = name;
        prices = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<MonthPrice> getPrice() {
        return prices;
    }

    public void addPrice(MonthPrice monthPrice){
        prices.add(monthPrice);
    }
}
