package homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.service.impl;

import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.ProductDao;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.dao.impl.ProductDAOImpl;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.domain.Product;
import homeworks.vladyslav_lazin.hw_2024.hw_30_06_24.service.ProductService;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao;

    public ProductServiceImpl() {
        this.productDao = new ProductDAOImpl();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(int id) {
        return productDao.findById(id);
    }
}
