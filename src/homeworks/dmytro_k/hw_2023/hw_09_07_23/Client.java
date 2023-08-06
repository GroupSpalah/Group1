package homeworks.dmytro_k.hw_2023.hw_09_07_23;

import java.util.List;

public class Client {
    private String login;
    private Basket basket;

    public Client(String login) {
        this.login = login;
        basket = new Basket();
    }

    public void addItem(Product product, ProductService productRange) {
        System.out.println(this.login + " add: ");
        System.out.println(product.getName()); // выводит в консоль только последнюю позицию? только со статикой
        basket.addItem(product, productRange);
    }

    public void remove(Product product) {
        System.out.println(this.login + " remove: ");
        System.out.println(product.getName());
        basket.removeItem(product);
    }

    public Basket getBasket() {
        return basket;
    }

    public void getBasketContents() {// не выводит содержимое корзины без статики

        basket.getItemsCount();
    }


    //переделать
    public void buy() {
        ProductService productService = new ProductService();
        Basket basket = new Basket();
        productService.getProducts();
        List<Product> items = basket.getItems();
        System.out.println(this.login + " bought: ");
        productService.sale(items);
    }
}
