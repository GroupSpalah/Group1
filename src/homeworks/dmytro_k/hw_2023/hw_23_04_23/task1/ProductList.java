package homeworks.dmytro_k.hw_2023.hw_23_04_23.task1;

import java.time.Month;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductList {

    private List<Product> products;

    public ProductList() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public float getPrice(String name, Month month) {

        Iterator<Product> productIterator = products.iterator();
        float price = 0;

        while (productIterator.hasNext()) {
            Product product = productIterator.next();

            if (name.equalsIgnoreCase(product.getName())) {
                List<MonthPrice> prices = product.getPrice();

                Iterator<MonthPrice> monthPriceIterator = prices.iterator();

                while (monthPriceIterator.hasNext()) {
                    MonthPrice monthPrice = monthPriceIterator.next();

                    if (month.equals(monthPrice.getMonth())) {
                        price = monthPrice.getPrice();
                    }
                }
            }
        }
        return price;
    }
}
