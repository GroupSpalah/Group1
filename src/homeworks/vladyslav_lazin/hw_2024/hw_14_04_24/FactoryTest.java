package homeworks.vladyslav_lazin.hw_2024.hw_14_04_24;

import java.util.concurrent.TimeUnit;

public class FactoryTest {
    public static void main(String[] args) throws InterruptedException {
        Customer customer1 = new Customer();
        customer1.createOrder("Article_1", "John",
                new Stage[]{new Stage("Stage_1", 30),
                        new Stage("Stage_2", 12)});
        TimeUnit.SECONDS.sleep(1);
        System.out.println(customer1.getProduct().prodName());
        System.out.println(customer1.getOrderInfo());
        TimeUnit.SECONDS.sleep(1);
        customer1.cancelOrder("It's so boring!");

        Customer customer2 = new Customer();
        customer2.createOrder("Article_2", "Vasya",
                new Stage[]{new Stage("Stage_1", 5),
                        new Stage("Stage_2", 12),
                        new Stage("Stage_3", 7)});
        TimeUnit.SECONDS.sleep(6);
        System.out.println(customer2.getProduct().prodName());
        System.out.println(customer2.getOrderInfo());
    }
}
