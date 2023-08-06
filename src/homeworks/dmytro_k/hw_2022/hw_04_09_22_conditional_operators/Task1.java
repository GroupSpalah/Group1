package homeworks.dmytro_k.hw_2022.hw_04_09_22_conditional_operators;

// 1) Написать логическое выражение для выбора коэффициента учета
// стажа работы по специальности в конкурсе на бюджетные места.Если
// стаж до 2 лет, то коэффициент равен 11, если стаж от 2 до 5 лет –12,
// если больше 5 лет –13.

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        double experience = getNumber();
        int coef = 0;

        if (experience < 0) {
            System.out.println("Input Error. Experience cannot be less than 0.");
        } else if (experience < 2) {
            coef = 11;
        } else if (2 <= experience && experience < 5) {
            coef = 12;
        } else if (experience >= 5) {
            coef = 13;
        }
        System.out.println("work experience accounting coefficient: " + coef);
    }

    public static double getNumber() {
        Scanner numb = new Scanner(System.in);
        System.out.println("enter the number:");
        if (numb.hasNextDouble()) {
            return numb.nextDouble();
        } else {
            System.out.println("Input error. Retype.");
            return getNumber();
        }
    }
}
