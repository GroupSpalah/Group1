package homeworks.dmytro_k.hw_2024.hw_17_03_24.task3;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public synchronized void deposit(double sum) {
        if (sum >= 0) {
            balance += sum;
            System.out.println("The balance was replenished on " + sum + "$");
            System.out.println("Balance: " + balance);
        }
    }

    public synchronized void withdrawal(double sum) {
        if (sum >= 0) {
            balance -= sum;
            System.out.println("Was withdrawal from balance " + sum + "$");
            System.out.println("Balance: " + balance);
        }
    }
}
