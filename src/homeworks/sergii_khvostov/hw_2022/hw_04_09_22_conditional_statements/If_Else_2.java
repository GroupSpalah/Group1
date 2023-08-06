package homeworks.sergii_khvostov.hw_2022.hw_04_09_22_conditional_statements;

//@Khvostov

//Дано число, нужно вывести в консоль оно больше/меньше/равно нулю.

public class If_Else_2 {
    public static void main(String[] args) {
        int number = 0;

        if (number == 0) {
            System.out.println("Number " + number + " = 0");
        } else if (number > 0) {
            System.out.println("Number " + number + " > 0");
        } else if (number < 0) {
            System.out.println("Number " + number + " < 0");
        }
    }
}
