package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(int id);

    void updateProduct(Product product);

    void deleteProduct(int id);
}
