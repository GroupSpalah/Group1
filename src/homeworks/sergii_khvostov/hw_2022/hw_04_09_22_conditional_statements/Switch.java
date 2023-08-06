package homeworks.sergii_khvostov.hw_2022.hw_04_09_22_conditional_statements;

//@Khvostov

/*Switch:
   number = 3;        number = 10;    number = 15;
   output: "FIN".     output: "RA".   output: "FINRA".*/

public class Switch {
    public static void main(String[] args) {
        int number = 15;

        switch (number) {
            case 3 -> System.out.println("FIN");
            case 10 -> System.out.println("RA");
            case 15 -> System.out.println("FINRA");
            default -> System.out.println("Ivalid");
        }
    }
}
