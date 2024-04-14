package homeworks.vladyslav_lazin.hw_2024.hw_17_03_24.task3;

public class Withdrawal implements Runnable {
    private final float amount;
    private final BankAccount bankAccount;

    public Withdrawal(BankAccount bankAccount, float amount) {
        this.amount = amount;
        this.bankAccount = bankAccount;
        Thread thread = new Thread(this);
        thread.start();
    }
    @Override
    public void run() {
        synchronized (bankAccount) {
            bankAccount.setAmount(bankAccount.getAmount() - amount);
            System.out.printf("Taken %s$, amount in bank - %s$%n", amount, bankAccount.getAmount());
        }
    }
}
