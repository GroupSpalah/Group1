package homeworks.dmytro_k.hw_2023.hw_09_07_23;

/**
 * 1) добавление сопутствующих товаров.
 * <p>
 * Создать классы без логики, только поля --
 **/

public class Product {
    private String name;
    private String manufacturer;
    private String manufactureDate;
    private Category category;
    private SubCategory subCategory;
    private float price;
    private int count;

    public Product(String name, String manufacturer, String manufactureDate, Category category,
                   SubCategory subCategory, float price, int count) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.category = category;
        this.subCategory = subCategory;
        this.price = price;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public float getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

/**
 * Category, SubCategory
 * <p>
 * Phone - category - Phone, subcategory - Phone
 * Charger - category - Phone, subcategory - Charger
 * <p>
 * Phone item = new Phone()
 * Basket - List(item)
 * ProductService - List(item)
 */
