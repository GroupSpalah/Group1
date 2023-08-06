package homeworks.sergii_khvostov.hw_2023.hw_23_04_23.online_store;

public class User {
    private final String name;
    private final Basket basket;

    public User(String name, Basket basket) {
        this.name = name;
        this.basket = new Basket();
    }

    public String getName() {
        return name;
    }

    public Basket getBasket() {
        return basket;
    }
}
