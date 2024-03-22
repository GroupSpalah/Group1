package homeworks.vladyslav_lazin.hw_2024.hw_17_03_24.task3;

import java.util.Random;

public class Processing {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        Random random = new Random();

        for (int i = 0; i <= 10; i++) {
            float amount = (random.nextFloat() * 99.99f) + 0.01f;
            new Thread(new Deposit(bankAccount, amount));
        }

        for (int i = 0; i <= 5; i++) {
            float amount = (random.nextFloat() * 99.99f) + 0.01f;
            new Thread(new Withdrawal(bankAccount, amount));
        }
    }
}
