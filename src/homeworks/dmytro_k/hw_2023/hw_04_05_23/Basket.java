package homeworks.dmytro_k.hw_2023.hw_04_05_23;

import java.util.LinkedList;
import java.util.List;

public class Basket {
    private static List<Product> items;
    private List<Product> products;
    private List<ProductList> actualRange;
    private List<ProductList> rangeLists;
    ProductList productList;
    Range range;

    public Basket() {
        items = new LinkedList<>();
    }

    public static List<Product> getItems() {
        return items;
    }

    public void addItem(Product product) {
/*
         actualRange = range.getRange();

         while (actualRange.listIterator().hasNext()){

             ProductList listCategory = actualRange.listIterator().next();

             Iterator<Product> productIterator = listCategory.getProducts().listIterator();

             while (productIterator.hasNext()) {

                 Product assortmentProduct = productIterator.next();*/

        /*if (product.equals(assortmentProduct)) {*/
        if (Range.availability(product)) {
            items.add(product);
        } else {
            System.out.println("данный товар недоступен");
        }
    }


    public void removeItem(Product product) {
        items.remove(product);
    }

    public void getItemsNames() {
        while (items.listIterator().hasNext()) {
            System.out.println(items.listIterator().next().getName());
            break;
        }
    }
}
