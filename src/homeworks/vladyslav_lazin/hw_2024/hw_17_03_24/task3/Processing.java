package homeworks.vladyslav_lazin.hw_2024.hw_17_03_24.task3;

import java.util.Random;
import java.util.stream.IntStream;

public class Processing {
    private static final BankAccount bankAccount = new BankAccount();
    public static void main(String[] args) {
        Random random = new Random();
        IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Deposit(bankAccount, (random.nextFloat() * 99.99f) + 0.01f))
                .forEach(Thread::new);
        IntStream.rangeClosed(0, 4)
                .mapToObj(i -> new Withdrawal(bankAccount, (random.nextFloat() * 99.99f) + 0.01f))
                .forEach(Thread::new);
    }
}
