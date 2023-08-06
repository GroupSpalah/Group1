package homeworks.dmytro_k.hw_2022.hw_04_09_22_conditional_operators;

// 5) Switch
// 'A': excellent
// 'B': great job
// 'C': good
// 'D': passed
// 'F': failed
// other wise: invalid
import java.io.IOException;

public class Task5 {
    public static void main(String[] args) throws IOException {
        getLetter();
//        getLetterL();
    }

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
     static void getLetterL() throws IOException {

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
                getLetterL();
        }
    }
}
