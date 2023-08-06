package homeworks.dmytro_k.hw_2022.hw_13_11_22;

/*2) write a program that can check if the given website is valid website or not
               starts with: www.
               ends with: .com, .edu, .gov, startsWith, endsWith*/

public class Task2 {

    public static void main(String[] args) {

        String word = "www.oracle.com";

        boolean prefix = word.startsWith("www.");

        boolean domain = word.endsWith(".com");

        boolean domain2 = word.endsWith(".edu");

        boolean domain3 = word.endsWith(".gov");


        if (prefix  && domain  || domain2  || domain3 ) {
            System.out.println("ok");
        } else {
            System.out.println("not ok");
        }
    }
}
