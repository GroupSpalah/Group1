package homeworks.sergii_khvostov.hw_2022.hw_04_09_22_conditional_statements;

//@Khvostov

/*Write a program that can define the age groups of a person age groups are:
   Teenager (< 21);  Adult (>=21 && <55 ); Senior ( > 55 ).
   If age is negative or greater than 150, print invalid.*/

public class If_Else_3 {
    public static void main(String[] args) {
        int age = 151;

        if (age >= 0 && age < 21) {
            System.out.println("Teenager");
        } else if (age >= 21 && age < 55) {
            System.out.println("Adult");
        } else if (age >= 55 && age <= 150) {
            System.out.println("Senior");
        } else if (age < 0 || age > 150) {
            System.out.println("Invalid age");
        }
    }
}
