package homeworks.sergii_khvostov.hw_2023.hw_11_06_23.online_shop_new;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineStoreApp {
    private final Map<String, Product> products = new HashMap<>();
    private final Map<String, List<String>> relatedProducts = new HashMap<>();
    private final Map<String, Basket> userBaskets = new HashMap<>();

    public void addProduct(String name, String manufacturer, LocalDate productionDate,
                           int quantity, double price) {
        Product product = new Product(name, manufacturer, productionDate, quantity, price);
        products.put(product.getNAME(), product);
    }

    public void addRelatedProducts(String mainProductName, List<String> relatedProductNames) {
        relatedProducts.put(mainProductName, relatedProductNames);
    }

    public void removeProduct(String productName) {
        products.remove(productName);
        relatedProducts.remove(productName);
    }

    public void createBasket(String userName) {
        userBaskets.put(userName, new Basket());
    }

    public List<String> selectProductsByCriteria(String criteria) {
        List<String> selectedProducts = new ArrayList<>();
        for (String name : products.keySet()) {
            if (name.contains(criteria)) {
                selectedProducts.add(name);
            }
        }
        return selectedProducts;
    }

    public void addProductToBasket(String userName, String productName) {
        Basket basket = userBaskets.get(userName);
        if (basket != null) {
            Product product = products.get(productName);
            if (product != null) {
                basket.addProduct(product);
            } else {
                System.out.println("Product not found: " + productName);
            }
        } else {
            System.out.println("Basket not found for user: " + userName);
        }
    }

    public void removeProductFromBasket(String userName, String productName) {
        Basket basket = userBaskets.get(userName);
        if (basket != null) {
            Product product = products.get(productName);
            if (product != null) {
                basket.removeProduct(product);
            } else {
                System.out.println("Product not found: " + productName);
            }
        } else {
            System.out.println("Basket not found for user: " + userName);
        }
    }

    public void displayBasket(String userName) {
        Basket basket = userBaskets.get(userName);
        if (basket != null) {
            System.out.println("User: " + userName);
            System.out.println("Basket contents:");
            for (Product product : basket.getProducts()) {
                System.out.println(product.getNAME());
            }
        } else {
            System.out.println("Basket not found for user: " + userName);
        }
    }

    public double calculateBasketTotalPrice(String userName, BasketCalculator calculator) {
        Basket basket = userBaskets.get(userName);
        if (basket != null) {
            return calculator.calculateTotalPrice(basket.getProducts());
        } else {
            System.out.println("Basket not found for user: " + userName);
            return 0.0;
        }
    }
}
