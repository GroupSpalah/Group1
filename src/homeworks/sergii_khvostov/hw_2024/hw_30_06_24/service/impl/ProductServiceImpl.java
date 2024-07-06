package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.impl;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.ProductDAO;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Product;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service.ProductService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductDAO PRODUCT_DAO;

    @Override
    public void addProduct(Product product) {
        PRODUCT_DAO.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return PRODUCT_DAO.getAll();
    }

    @Override
    public Product getProductById(int id) {
        return PRODUCT_DAO.getById(id);
    }

    @Override
    public void updateProduct(Product product) {
        PRODUCT_DAO.update(product);
    }

    @Override
    public void deleteProduct(int id) {
        PRODUCT_DAO.delete(id);
    }
}
