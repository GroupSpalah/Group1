package homeworks.dmytro_k.hw_2022.hw_20_11_22.task4;

public class Task4 {

    public static void main(String[] args) {

        BankAccount bankAccount1 = new BankAccount();
        BankAccount bankAccount2 = new BankAccount();

        bankAccount1.consumption(123);
        bankAccount1.printBalance();

        bankAccount1.refill(300);
        bankAccount1.printBalance();

        bankAccount2.consumption(201);
        bankAccount2.printBalance();
    }
}
