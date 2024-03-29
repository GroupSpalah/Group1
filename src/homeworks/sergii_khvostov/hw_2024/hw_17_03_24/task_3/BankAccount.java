package homeworks.sergii_khvostov.hw_2024.hw_17_03_24.task_3;

/*Write a program that make operation with a bank account. Create a
   bank account class, place default money amount (1000 US dollars). Than
   make 10 sequent deposit operations and 5 withdrawal sequent operations.
   All operations must be run in separated threads.*/

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BankAccount implements Runnable {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit: " + amount + ", Balance: " + balance);
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal: " + amount + ", Balance: " + balance);
        } else {
            System.out.println("Insufficient funds for withdrawal: " + amount);
        }
    }

    private void executeOparation() {
        List<Thread> threads = new ArrayList<>();

        IntStream.range(0, 10).forEach(i -> {
            Thread depositThread = new Thread(() -> deposit(100));
            depositThread.start();
            threads.add(depositThread);
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        threads.clear();

        IntStream.range(0, 5).forEach(i -> {
            Thread withdrawThread = new Thread(() -> withdraw(200));
            withdrawThread.start();
            threads.add(withdrawThread);
        });

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void run() {
        executeOparation();
    }
}
