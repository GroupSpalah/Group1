package lessons.conditional_operators;

/*
* Написать логическое выражение для расчета суммы выплаты по
депозиту на вклад : до 5000 грн начисляется 20% годовых, от 5000 грн
до 10000 грн -22% годовых.
* */
public class Task1 {
    public static void main(String[] args) {
        double deposit = 8000;

        double percent = 0;

        /*if (deposit < 5000) {
            System.out.println("Add 20%");
        } else if (deposit > 5000 && deposit < 10000) {
            System.out.println("Add 22%");
        }*/

        /*if (deposit < 5000) {
            percent = deposit * 20 / 100;
        } else if (deposit > 5000 && deposit < 10000) {
            percent = deposit * 22 / 100;
        }*/

        if (deposit < 5000) {
            percent = 20;
        } else if (deposit > 5000 && deposit < 10000) {
            percent = 22;
        }

        double result = deposit + (deposit * percent / 100);

        System.out.println(result);
    }
}
