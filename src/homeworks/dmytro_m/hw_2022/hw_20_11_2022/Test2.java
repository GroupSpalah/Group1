package homeworks.dmytro_m.hw_2022.hw_20_11_2022;

public class Test2 {

    public static void main(String[] args) {
        BankAccount person1 = new BankAccount();
        person1.withdrawsAmountAccount(250);
        person1.replenishesAccount(50);
        System.out.println();
        BankAccount person2 = new BankAccount(300);
        person2.withdrawsAmountAccount(250);
        person2.replenishesAccount(50);
    }
}

class BankAccount {
    private int invoiceAmount = 200;

    public BankAccount() {
    }

    public BankAccount(int invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public int getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(int invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public void withdrawsAmountAccount(int sum) {
        if (this.getInvoiceAmount() >= sum) {
            this.setInvoiceAmount(this.getInvoiceAmount() - sum);
            System.out.println("Remaining on the account " + this.getInvoiceAmount());
        } else {
            System.out.println("Replenishment account");
        }
    }

    public void replenishesAccount(int sum) {
        this.setInvoiceAmount(this.getInvoiceAmount() + sum);
        System.out.println("Your account has been topped up " + sum + " dollars and amounts to " + this.getInvoiceAmount());
    }
}
//    Создать класс Банковский счет.
////        Установить изначально сумму для счета - 200$
////        Создать метод, который будет отнимать от счета сумму. Если денег недостаточно,
// тогда написать в консоль - "Пополните счет".
////        Счет можно пополнить другим методом.