package homeworks.dmytro_k.hw_2023.hw_04_05_23;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Range {

    private static List<ProductList> range;

    public Range() {
        range = new LinkedList<>();
    }

    public void addProducts(ProductList category) {
        range.add(category);
    }

    public List<ProductList> getRange() {
        return range;
    }

    public static boolean availability(Product product) {

        for (ProductList listCategory : range) {

            Iterator<Product> productIterator = listCategory.getProducts().listIterator();

            while (productIterator.hasNext()) {

                Product assortmentProduct = productIterator.next();

                if (product.equals(assortmentProduct)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static ProductList buyItems(/*ProductList items*/) {

        List<Product> items = Basket.getItems();

        ProductList productList = new ProductList();

        if (items.size() > 0) {
            while (items.listIterator().hasNext()) {
                Product basketItem = items.listIterator().next();
                String itemName = basketItem.getName();
                System.out.println(itemName + "***");
                //return basketItem;
                productList.addProduct(basketItem);//добавление товаров при покупке
            }
        } else {
            System.out.println("cart is empty");
        }
        return productList;
    }
}
