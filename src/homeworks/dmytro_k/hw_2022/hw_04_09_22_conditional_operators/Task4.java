package homeworks.dmytro_k.hw_2022.hw_04_09_22_conditional_operators;

// 4)Switch
// ex:
// number = 3
// output:
// FIN
// number = 10
// output:
// RA
// number = 15
import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {

        System.out.println("Enter: 3, 10 or 15");
        finRa();
//        finRaL();
    }

// Java 12
    static void finRa() {
        int number = getNumber();

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

//  Legacy code
     static void finRaL() { //static int
        int number = getNumber();

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
                finRaL();
            }
        }
//         return 0;
     }

    public static int getNumber() {
        Scanner numb = new Scanner(System.in);
        System.out.println("enter the number:");
        if (numb.hasNextInt()) {
            return numb.nextInt();
        } else {
            System.out.println("Input error. Retype.");
            return getNumber();
        }
    }
}











