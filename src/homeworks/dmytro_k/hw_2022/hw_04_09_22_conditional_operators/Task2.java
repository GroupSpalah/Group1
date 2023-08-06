package homeworks.dmytro_k.hw_2022.hw_04_09_22_conditional_operators;

// 2) Дано число, нужно вывести в консоль оно больше/меньше/равно нулю.

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        double numb = getNumber();

        if (numb > 0) {
            System.out.println("number greater than zero");
        } else if (numb < 0) {
            System.out.println("number less than zero");
        } else {
            System.out.println("number is zero");
        }
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
