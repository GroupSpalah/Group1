package homeworks.dmytro_k.hw_2023.hw_23_04_23.task2;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * 1) добавление сопутствующих товаров.
 * <p>
 * Создать классы без логики, только поля --
 **/

public abstract class Product {

    private String name;
    private String manufacturer;
    private Calendar manufactureDate;
    private List<Product> relatedProducts;

    public Product(String name, String manufacturer, Calendar manufactureDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        relatedProducts = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Calendar getManufactureDate() {
        return manufactureDate;
    }

    public void addRelatedProducts(Product product) {
        relatedProducts.add(product);
    }

    public void removeRelatedProducts(Product product) {
        relatedProducts.remove(product);
    }
}

/**
 * Category, SubCategory
 *
 * Phone - category - Phone, subcategory - Phone
 * Charger - category - Phone, subcategory - Charger
 *
 * Phone item = new Phone()
 * Basket - List(item)
 * ProductService - List(item)
 */
