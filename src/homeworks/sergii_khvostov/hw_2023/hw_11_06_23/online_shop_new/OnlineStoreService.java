package homeworks.sergii_khvostov.hw_2023.hw_11_06_23.online_shop_new;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OnlineStoreService {
    public static void main(String[] args) {
        OnlineStoreApp onlineStore = new OnlineStoreApp();

        onlineStore.addProduct("Phone", "Samsung", LocalDate.now(), 10, 500.0);
        onlineStore.addProduct("Laptop", "HP", LocalDate.now(), 5, 1000.0);

        List<String> relatedProducts = new ArrayList<>();
        relatedProducts.add("Phone case");
        relatedProducts.add("Earphones");
        onlineStore.addRelatedProducts("Phone", relatedProducts);

        onlineStore.createBasket("John");
        onlineStore.addProductToBasket("John", "Phone");

        List<String> selectedProducts = onlineStore.selectProductsByCriteria("Phone");
        System.out.println("Selected products: " + selectedProducts);

        onlineStore.displayBasket("John");

        double totalPrice = onlineStore.calculateBasketTotalPrice("John", products -> {
            double total = 0.0;
            for (Product product : products) {
                total += product.getPrice();
            }
            return total;
        });
        System.out.println("Total price of the basket: " + totalPrice);
    }
}
