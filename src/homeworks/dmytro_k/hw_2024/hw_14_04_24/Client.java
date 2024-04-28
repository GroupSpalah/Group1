package homeworks.dmytro_k.hw_2024.hw_14_04_24;


public class Client {

    private final String name;
    private final Factory factory;

    public Client(String name, Factory factory) {
        this.name = name;
        this.factory = factory;
    }

    public void makeOrder(String productName, int productAmount) {
        Order order = new Order(productName, productAmount, factory);
        order.newOrder();
    }

    public void getActualStage(int repeatCounter, int timeUntilRequest, int timeBetweenRequests) {
        factory.getActualInfo(repeatCounter, timeUntilRequest, timeBetweenRequests);
    }
}
