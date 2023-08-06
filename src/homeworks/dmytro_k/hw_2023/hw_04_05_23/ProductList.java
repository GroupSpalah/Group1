package homeworks.dmytro_k.hw_2023.hw_04_05_23;

import java.util.LinkedList;
import java.util.List;

public class ProductList {

    private List<Product> products;

    public ProductList() {
        products = new LinkedList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {

        Category category = product.getCategory();

        if (products.isEmpty()) {
            products.add(product);
        }

        Category listCategory = products.get(0).getCategory();

        if (category == listCategory) {
            products.add(product);
        } else {
            System.out.println("Категория данного товара не соответствует выбранному списку товаров" +
                    "выберите соответствующий список или создайте новый.");
        }
    }

    public int getSize() {
        return products.size();
    }


    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void sale(ProductList productList) { // перебор входящегосписка и удаление из ассортимента


/*        if (productList != null){
            while ()

            removeProduct(product);
        }*/
    }
}
