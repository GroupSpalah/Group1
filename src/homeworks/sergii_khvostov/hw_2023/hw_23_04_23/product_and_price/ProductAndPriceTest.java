package homeworks.sergii_khvostov.hw_2023.hw_23_04_23.product_and_price;

import java.util.ArrayList;
import java.util.List;

public class ProductAndPriceTest {
    public static void main(String[] args) {

        List<PriceOfMonth> prices1 = new ArrayList<>();
        prices1.add(new PriceOfMonth("Jan", 50));
        prices1.add(new PriceOfMonth("Feb", 60));
        prices1.add(new PriceOfMonth("Mar", 70));
        prices1.add(new PriceOfMonth("Apr", 80));
        prices1.add(new PriceOfMonth("May", 90));
        prices1.add(new PriceOfMonth("Jun", 100));
        prices1.add(new PriceOfMonth("Jul", 110));
        prices1.add(new PriceOfMonth("Aug", 120));
        prices1.add(new PriceOfMonth("Sep", 130));
        prices1.add(new PriceOfMonth("Oct", 140));
        prices1.add(new PriceOfMonth("Nov", 150));
        prices1.add(new PriceOfMonth("Dec", 160));

        List<PriceOfMonth> prices2 = new ArrayList<>();
        prices2.add(new PriceOfMonth("Jan", 45));
        prices2.add(new PriceOfMonth("Feb", 55));
        prices2.add(new PriceOfMonth("Mar", 65));
        prices2.add(new PriceOfMonth("Apr", 75));
        prices2.add(new PriceOfMonth("May", 85));
        prices2.add(new PriceOfMonth("Jun", 95));
        prices2.add(new PriceOfMonth("Jul", 105));
        prices2.add(new PriceOfMonth("Aug", 115));
        prices2.add(new PriceOfMonth("Sep", 125));
        prices2.add(new PriceOfMonth("Oct", 135));
        prices2.add(new PriceOfMonth("Nov", 145));
        prices2.add(new PriceOfMonth("Dec", 155));

        List<PriceOfMonth> prices3 = new ArrayList<>();
        prices3.add(new PriceOfMonth("Jan", 10));
        prices3.add(new PriceOfMonth("Feb", 20));
        prices3.add(new PriceOfMonth("Mar", 30));
        prices3.add(new PriceOfMonth("Apr", 40));
        prices3.add(new PriceOfMonth("May", 50));
        prices3.add(new PriceOfMonth("Jun", 60));
        prices3.add(new PriceOfMonth("Jul", 70));
        prices3.add(new PriceOfMonth("Aug", 80));
        prices3.add(new PriceOfMonth("Sep", 90));
        prices3.add(new PriceOfMonth("Oct", 100));
        prices3.add(new PriceOfMonth("Nov", 110));
        prices3.add(new PriceOfMonth("Dec", 120));

        Product product1 = new Product("Product1", prices1);
        Product product2 = new Product("Product2", prices2);
        Product product3 = new Product("Product3", prices3);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        ProductService productService = new ProductService(products);

        int price1Jan = productService.getPrice("Product1", "Jan");
        int price2Dec = productService.getPrice("Product2", "Dec");

        System.out.println("Price for Product1 in Jan: " + price1Jan);
        System.out.println("Price for Product2 in Dec: " + price2Dec);

    }
}









