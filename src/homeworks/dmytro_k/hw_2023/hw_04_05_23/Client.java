package homeworks.dmytro_k.hw_2023.hw_04_05_23;

public class Client {
    private String login;
    private String password;
    private Basket basket;

    public Client(String login, String password) {
        this.login = login;
        this.password = password;
        basket = new Basket();
    }

    public void addItem(Product product) {
        basket.addItem(product);
        System.out.println(this.login + " add: ");
        basket.getItemsNames();
    }

    public void remove(Product product) {
        basket.removeItem(product);
        System.out.println(this.login + " remove: ");
        basket.getItemsNames();
    }

    public void buy() {
        System.out.println(this.login + " bought: ");
        Range.buyItems();
    }
}
