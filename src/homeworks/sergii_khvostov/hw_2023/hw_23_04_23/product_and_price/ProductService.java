package homeworks.sergii_khvostov.hw_2023.hw_23_04_23.product_and_price;

import java.util.List;

public class ProductService {

    private List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public int getPrice(String productName, String month) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product.getPrice(month);
            }
        }
        return 0;
    }
}


