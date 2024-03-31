package homeworks.dmytro_k.hw_2024.hw_17_03_24.task3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);

        ExecutorService service = Executors.newFixedThreadPool(2);

        IntStream
                .range(0, 10)
                .forEach(i -> service.submit(() -> bankAccount.deposit(100)));

        IntStream
                .range(0, 5)
                .forEach(i -> service.submit(() -> bankAccount.withdrawal(50)));

        service.shutdown();
    }
}

