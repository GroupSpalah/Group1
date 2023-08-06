package homeworks.dmytro_k.hw_2022.hw_04_09_22_conditional_operators;

// 3) write a program that can define the age groups of a person
// age groups are:
// Teenager (< 21)
// Adult   (>=21 && <55 )
// Senior  ( > 55 )
import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        double age = getNumber();

        if (age < 0 || age > 150) {
            System.out.println("Invalid input");
        } else if (age < 21) {
            System.out.println("Teenager");
        } else if (age >= 21 && age < 55) {
            System.out.println("Adult");
        } else if (age >= 55) {
            System.out.println("Senior");
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

