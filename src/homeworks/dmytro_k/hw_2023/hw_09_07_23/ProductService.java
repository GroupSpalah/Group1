package homeworks.dmytro_k.hw_2023.hw_09_07_23;

import java.util.LinkedList;
import java.util.List;

public class ProductService {

    private List<Product> products;

    //почему равен нулю в корзине при добавлении???
    public ProductService() {
        products = new LinkedList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public int getSize() {
        return products.size();
    }

    /**
     * удаление продукта из ассортимента
     **/

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void sale(List<Product> items) {
        for (Product product : products) {
            int productCount = product.getCount();
            for (Product item : items) {
                int itemCount = item.getCount();
                System.out.println(itemCount+"itemC");
                if (item.equals(product)) {
                    int newQuantity = productCount - itemCount;
                    if (newQuantity > 0) {
                        product.setCount(newQuantity);
                    } else {
                        product.setCount(0);
                        System.out.println("доступное кол-во для покупки: " + productCount);//???
                    }
                }
            }
        }
    }

    /**
     * вывод ассортимента
     **/

    public void printProduct() {

        for (Product product : products) {
            String productName = product.getName();
            System.out.println(productName + product.getCount());
        }
    }

    /**
     * вывод ассортимента по категории
     **/

    public void printProduct(Category category) {

        for (Product product : products) {
            Category productCategory = product.getCategory();
            String productName = product.getName();
            if (category.equals(productCategory))
                System.out.println(productName + product.getCount());
        }
    }

    /**
     * вывод ассортимента по субкатегории
     **/

    public void printProduct(SubCategory subCategory) {

        for (Product product : products) {
            SubCategory productSubCategory = product.getSubCategory();
            String productName = product.getName();
            if (subCategory.equals(productSubCategory))
                System.out.println(productName + product.getCount());
        }
    }

    /**
     * этот метод возвращает не продукт по имени, а имя продукта в наличии
     **/
    public void getProductByNameFor(String name) {

        int count = 0;

        for (Product product : products) {
            String productName = product.getName();
            if (name.equalsIgnoreCase(productName)) {
                System.out.println(productName + product.getCount());
                count++;
            }
        }

        if (count == 0) {
            System.out.println("this item is not available");
        }
    }

    public void printList() {
        while (products.listIterator().hasNext()) {
            Product product = products.listIterator().next();
            System.out.println(product.getName());
        }
    }
}
