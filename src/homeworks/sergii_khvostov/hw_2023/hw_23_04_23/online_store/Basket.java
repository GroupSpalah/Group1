package homeworks.sergii_khvostov.hw_2023.hw_23_04_23.online_store;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Product> products = new ArrayList<>();


    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void clear() {
        products.clear();
    }
}
