package homeworks.sergii_khvostov.hw_2024.hw_17_03_24.task_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class BankAccountService {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000);
        Thread thread = new Thread(bankAccount);
        thread.start();
    }
}

