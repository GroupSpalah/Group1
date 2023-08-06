package homeworks.dmytro_k.hw_2022.hw_04_09_22_conditional_operators;

// 1) Написать логическое выражение для выбора коэффициента учета
// стажа работы по специальности в конкурсе на бюджетные места.Если
// стаж до 2 лет, то коэффициент равен 11, если стаж от 2 до 5 лет –12,
// если больше 5 лет –13.
//
// 2) Дано число, нужно вывести в консоль оно больше/меньше/равно нулю.
//
// 3) write a program that can define the age groups of a person
// age groups are:
// Teenager (< 21)
// Adult   (>=21 && <55 )
// Senior  ( > 55 )
//
// if age is negative or greater than 150, print invalid
//
// 4)Switch
// ex:
// number = 3
// output:
// FIN
// number = 10
// output:
// RA
// number = 15
// 5) Switch      'A': excellent
// 'B': great job
// 'C': good
// 'D': passed
// 'F': failed
// other wise: invalid
//
// Java 12 and older;
//
// https://mkyong.com/java/java-12-switch-expressions/
import java.io.IOException;
import java.util.Scanner;

public class AllTasks {

    public static void main(String[] args) throws IOException {

//         Task 1
        System.out.println("task 1" +
                "\n Work experience");

        double experience = getNumber(); //стаж работы
        int coef = 0; //коэффициента учета стажа работы

        if (experience < 0){
            System.out.println("Input Error. Experience cannot be less than 0.");
        } else if (experience < 2) {
            coef = 11;
        } else if (2 <= experience && experience < 5) {
            coef = 12;
        } else if (experience >= 5) {
            coef = 13;
        }
        System.out.println("work experience accounting coefficient: " + coef);

//        Task 2
        System.out.println("task 2");

        double numb = getNumber();

        if (numb > 0) {
            System.out.println("number greater than zero");
        } else if ( numb < 0) {
            System.out.println("number less than zero");
        } else {
            System.out.println("number is zero");
        }

//         Task 3
        System.out.println("task 3" +
                "\nAge groups");

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

//         Task 4
        System.out.println("task 4" +
                "\nNumber must be 3, 10 or 15");
//        finRa();
        finRaLegacy();


//         Task 5
        System.out.println("task 5");
//        getLetter();
        getLetterLegacy();
    }

     static double getNumber() {
        Scanner numb = new Scanner(System.in);
        System.out.println("enter the number:");
        if (numb.hasNextDouble()) {
            return numb.nextDouble();
        } else {
            System.out.println("Input error. Retype.");
            return getNumber();
        }
    }

//    Java 12

//    4)
    static void finRa () {
        int number = (int) getNumber();

        switch (number) {
            case 3 -> System.out.println("FIN");
            case 10 -> System.out.println("RA");
            case 15 -> System.out.println("FINRA");
            default -> {
                System.out.println("Input error. Retype." +
                        "\nNumber must be 3, 10 or 15");
                finRa();
            }
        }
    }

//      5)
    static void getLetter() throws IOException {

        System.out.println("Type the letter (A, B, C, D or F) and hit Enter." +
                "\n(be case sensitive)");

        char letter = (char) System.in.read();
        switch (letter) {
            case 'A' -> System.out.println("excellent");
            case 'B' -> System.out.println("great job");
            case 'C' -> System.out.println("good");
            case 'D' -> System.out.println("passed");
            case 'F' -> System.out.println("failed");
            default -> {
                System.out.println("Invalid input. \nTry again.");
                getLetter();
            }
        }
    }

//    Legacy code

//      4)
    static void finRaLegacy() {

        int number = (int) getNumber();

        switch (number) {
            case 3:
                System.out.println("FIN");
                break;
            case 10:
                System.out.println("RA");
                break;
            case 15:
                System.out.println("FINRA");
                break;
            default: {
                System.out.println("Input error. Retype." +
                        "\nNumber must be 3, 10 or 15");
                finRaLegacy();
            }
        }
    }


//      5)
     static void getLetterLegacy() throws IOException {

        System.out.println("Type the letter (A, B, C, D or F) and hit Enter." +
                "\n(be case sensitive)");

        char letter = (char) System.in.read();
        switch (letter) {
            case 'A':
                System.out.println("excellent");
                break;
            case 'B':
                System.out.println("great job");
                break;
            case 'C':
                System.out.println("good");
                break;
            case 'D':
                System.out.println("passed");
                break;
            case 'F':
                System.out.println("failed");
                break;
            default:
                System.out.println("Invalid input. \nTry again.");
                getLetterLegacy();
        }
    }
}

