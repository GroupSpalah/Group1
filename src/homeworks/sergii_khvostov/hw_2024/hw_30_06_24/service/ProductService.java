package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.DAOFactory;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.ProductDAO;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private final ProductDAO PRODUCT_DAO = DAOFactory.getProductDAO();

    public void createProduct(String name, String description, BigDecimal price) {
        Product product = new Product(name, description, price);
        PRODUCT_DAO.add(product);
    }

    public List<Product> getAllProducts() {
        return PRODUCT_DAO.getAll();
    }

    public Product getProductById(int id) {
        return PRODUCT_DAO.getById(id);
    }

    public void updateProduct(Product product) {
        PRODUCT_DAO.update(product);
    }

    public void deleteProduct(int id) {
        PRODUCT_DAO.delete(id);
    }
}
