package homeworks.sergii_khvostov.hw_2023.hw_23_04_23.online_store;

import java.util.ArrayList;
import java.util.List;

public class ProductController {
    List<Product> products = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    List<SubCategory> subCategories = new ArrayList<>();


    public ProductController(List<Product> products, List<Category> categories,
                             List<SubCategory> subCategories) {
        this.products = products;
        this.categories = categories;
        this.subCategories = subCategories;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void removeCategory(Category category) {
        categories.remove(category);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addSubCategory(SubCategory subCategory) {
        subCategories.add(subCategory);
    }

    public void removeSubCategory(SubCategory subCategory) {
        subCategories.remove(subCategory);
    }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public List<Product> findProductByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product productName : products) {
            if (productName.getName().equals(name)) {
                result.add(productName);
            }

        }
        return result;
    }

}



