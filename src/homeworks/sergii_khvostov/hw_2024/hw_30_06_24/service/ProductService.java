package homeworks.sergii_khvostov.hw_2024.hw_30_06_24.service;

import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.DAOFactory;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.dao.ProductDAO;
import homeworks.sergii_khvostov.hw_2024.hw_30_06_24.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductService {
    private final ProductDAO productDAO = DAOFactory.getProductDAO();

    public void createProduct(String name, String description, BigDecimal price) {
        Product product = new Product(name, description, price);
        productDAO.add(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    public Product getProductById(int id) {
        return productDAO.getById(id);
    }

    public void updateProduct(Product product) {
        productDAO.update(product);
    }

    public void deleteProduct(int id) {
        productDAO.delete(id);
    }
}
