package homeworks.vladyslav_lazin.hw_2024.hw_14_04_24;

import java.util.concurrent.TimeUnit;

public class FactoryTest {
    public static void main(String[] args) throws InterruptedException {
        Customer customer = new Customer();
        customer.createOrder("Article_1", "John",
                new Stage[]{new Stage("Stage_1", 30),
                        new Stage("Stage_2", 12)});
        TimeUnit.SECONDS.sleep(1);
        System.out.println(customer.getOraderInfo());
        TimeUnit.SECONDS.sleep(1);
        customer.cancelOrder("It's so boring!");
    }
}
