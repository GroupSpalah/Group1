package homeworks.sergii_khvostov.hw_2022.hw_20_11_22;

//Khvostov

/*Создать класс Банковский счёт.
  Установить изначально сумму для счёта - 200$
  Создать метод, который будет отнимать от счёта сумму.
  Если денег недостаточно, тогда написать в консоль - "Пополните счёт".
  Счёт можно пополнить другим методом.*/

public class BankAccount {
    double bankAccount = 200;

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();

        double takeOff = bankAccount1.withdrawsMoney(150);
        System.out.println(takeOff);

        double put = bankAccount1.replenishesAccount(100);
        System.out.println(put);
    }

    public double withdrawsMoney(double amountWithdraws) {
        if (amountWithdraws > bankAccount) {
            System.out.println("Top up your account");

        } else {
            bankAccount -= amountWithdraws;
        }
        return bankAccount;
    }

    public double replenishesAccount(double amountReplenishes) {
        bankAccount += amountReplenishes;
        return bankAccount;
    }
}
