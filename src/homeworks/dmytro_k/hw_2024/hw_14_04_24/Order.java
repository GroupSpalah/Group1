package homeworks.dmytro_k.hw_2024.hw_14_04_24;

public class Order {

    private final String name;
    private final int amount;
    private final Factory factory;

    public Order(String name, int amount, Factory factory) {
        this.name = name;
        this.amount = amount;
        this.factory = factory;
    }

    public void newOrder() {
        factory.startProduction(name, amount);
    }
}
