package homeworks.sergii_khvostov.hw_2022.hw_13_11_2022_string;

//@Khvostov

/*write a program that can check if the given website is valid website or not
               starts with: www.
               ends with: .com, .edu, .gov, startsWith, endsWith*/

public class Task2 {
    public static void main(String[] args) {
        String email = null;

        if (email.startsWith("www.") && email.endsWith(".com") ||
                email.endsWith(".edu") || email.endsWith(".gov")) {
            System.out.println("This is website");
        } else {
            System.out.println("Is not website");
        }


        /* String[] email1 = email.split(".");

        if (email1[0].equals("www") && email1[2].equals("com") ||
                email1[2].equals("edu") || email1[2].equals("gov")) {
            System.out.println("This is website");

        }else {
            System.out.println("Is not website");
        }
    }*/
    }
}
