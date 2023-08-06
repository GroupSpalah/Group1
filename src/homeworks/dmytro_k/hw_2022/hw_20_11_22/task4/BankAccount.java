package homeworks.dmytro_k.hw_2022.hw_20_11_22.task4;

/*4) ++Создать класс Банковский счет.
      ++ Установить изначально сумму для счета - 200$
      ++ Создать метод, который будет отнимать от счета сумму. Если денег недостаточно,
       тогда написать в консоль - "Пополните счет".
      ++ Счет можно пополнить другим методом.*/

public class BankAccount {

    private double balance;

    public BankAccount() {

        this.balance = 200;
    }

    public double getBalance() {

        return balance;
    }

    public void consumption(double amountOfMoney) {

        if (balance < 0){
            System.out.println("Invalid input");
            return;
        }

        if (balance >= amountOfMoney) {
            balance -= amountOfMoney;
        } else {
            System.out.println("Top up your account.");
        }
    }

    public void refill(double amountOfMoney) {

        balance += amountOfMoney;
    }

    public void printBalance() {

        System.out.println("Balance: " + getBalance());
    }
}

