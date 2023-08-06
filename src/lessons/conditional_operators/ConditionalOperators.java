package lessons.conditional_operators;

public class ConditionalOperators {
    public static void main(String[] args) {
        int age = 70;

        /*if (age >= 10) {
            System.out.println("age >= 10");
        } else {
            System.out.println("age < 10");
        }*/

      /*  if (age > 10) {
            System.out.println("age > 10");
        } else if(age == 10) {
            System.out.println("age == 10");
        } else {
            System.out.println("age < 10");
        }*/

        int b = 0;

        if (age > 10) {
            b = 20;
        } else {
            b = 30;
        }

//        ternary operator
//        condition ? statement if condition is true : statement is condition is false;

//        b = age > 10 ? 20 : 30;
//        b = age > 10 ? (age == 15 ? 40 : 50) : 30;


     /*   if (age == 10) {
            b = 20;
        } else if (age == 20) {
            b = 30;
        } else if (age == 30) {
            b = 40;
        }*/

        switch (age) {
            case 10:
                b = 20;
                break;
            case 20:
                b = 30;
                break;
            case 30:
                b = 40;
                break;
            default:
                b = 100;
        }

                System.out.println(b);
    }
}
