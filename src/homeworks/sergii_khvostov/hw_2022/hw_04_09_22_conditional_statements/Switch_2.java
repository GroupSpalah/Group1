package homeworks.sergii_khvostov.hw_2022.hw_04_09_22_conditional_statements;

//@Khvostov

/*Switch:
   'A': excellent; 'B': great job; 'C': good; 'D': passed; 'F': failed.
   Other wise: invalid.*/

public class Switch_2 {
    public static void main(String[] args) {
        char letter = '0';

        switch (letter) {
            case 'A' -> System.out.println("Excellent");
            case 'B' -> System.out.println("Great job");
            case 'C' -> System.out.println("Good");
            case 'D' -> System.out.println("Passed");
            case 'F' -> System.out.println("Failed");
            default -> System.out.println("Invalid");
        }
    }
}
