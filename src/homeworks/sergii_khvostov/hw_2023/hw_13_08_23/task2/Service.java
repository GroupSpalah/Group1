package homeworks.sergii_khvostov.hw_2023.hw_13_08_23.task2;

/*Товар(название, дата производства, производитель, хрупкость, цена),
Производитель товара(название фирмы, страна производства).

Выбрать товары:
1) Одного производителя по названию, хрупкие
2) Хрупкие
3) Товары, цена которых лежит в определенном промежутке.*/

import java.util.ArrayList;
import java.util.List;


public class Service {
    public static void main(String[] args) {

        Manufacturer manufacturer1 = new Manufacturer("Asus", "China");
        Manufacturer manufacturer2 = new Manufacturer("Acer", "China");
        Manufacturer manufacturer3 = new Manufacturer("HP", "USA");

        List<Product> products = new ArrayList<>();
        products.add(new Product("product1", "05/01/2001", manufacturer1,
                true, 1200));
        products.add(new Product("product2", "07/05/2005", manufacturer2,
                true, 1300));
        products.add(new Product("product3", "08/07/2012", manufacturer3,
                false, 1500));


        List<Product> fragileProductsByManufacturer = products.stream()
                .filter(Product::isFragility)
                .filter(product -> product.getManufacturer().getName().equals(manufacturer1)).toList();

        List<Product> fragileProduct = products.stream()
                .filter(Product::isFragility).toList();

        List<Product> priceInRange = products.stream()
                .filter(product -> product.getPrice() >= 50 && product.getPrice() <= 100).toList();

    }
}
