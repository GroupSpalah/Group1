package homeworks.vladyslav_lazin.hw_2024.hw_17_03_24.task3;

public class Deposit implements Runnable {
    private final float amount;
    private final BankAccount bankAccount;

    public Deposit(BankAccount bankAccount, float amount) {
        this.amount = amount;
        this.bankAccount = bankAccount;
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        synchronized (bankAccount) {
            float amountOnAccount = bankAccount.getAmount();
            bankAccount.setAmount(amountOnAccount += amount);
            System.out.printf("Added %s$, amount in bank - %s$%n", amount, bankAccount.getAmount());
        }
    }
}
