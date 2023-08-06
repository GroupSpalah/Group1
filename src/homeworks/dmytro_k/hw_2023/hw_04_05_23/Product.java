package homeworks.dmytro_k.hw_2023.hw_04_05_23;

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

    public Product(String name, String manufacturer, String manufactureDate, Category category,
                   SubCategory subCategory, float price) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.manufactureDate = manufactureDate;
        this.category = category;
        this.subCategory = subCategory;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getManufactureDate() {
        return manufactureDate;
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
