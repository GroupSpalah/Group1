package homeworks.sergii_khvostov.hw_2023.hw_11_06_23.online_shop_new;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
