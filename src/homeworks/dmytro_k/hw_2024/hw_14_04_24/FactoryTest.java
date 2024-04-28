package homeworks.dmytro_k.hw_2024.hw_14_04_24;


public class FactoryTest {

    public static void main(String[] args) {
        Factory factory = new Factory();

        Client client1 = new Client("Jack", factory);
        Runnable someProduct = () -> client1.makeOrder("Some Product", 2);

        Runnable actualStage = () -> client1.getActualStage(5, 5, 3);

        Thread thread1 = new Thread(someProduct);
        thread1.start();

        Thread thread2 = new Thread(actualStage);
        thread2.start();
    }
}
