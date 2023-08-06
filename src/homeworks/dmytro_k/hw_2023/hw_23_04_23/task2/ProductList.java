package homeworks.dmytro_k.hw_2023.hw_23_04_23.task2;

/**
 * 1) добавление товара(название, производитель, дата производства и т.д.).
 * 2) удаление товара с сопутствующими товарами.
 * 3) выбор товара по определенным критериям и после выводить сопутствующие товары.
 * 4) Учесть, что каждого товара определенное количество в магазине.
 **/

import java.util.LinkedList;
import java.util.List;

public class ProductList {
    private final List<Product> products;

    public ProductList() {
        products = new LinkedList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProducts(Product product) {
        products.remove(product);
    }

    public void removeProducts(int index) {
        products.remove(index);
    }

    public void productListSize() {
        products.size();
    }
}
