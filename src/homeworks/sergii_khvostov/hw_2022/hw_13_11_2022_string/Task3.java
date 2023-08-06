package homeworks.sergii_khvostov.hw_2022.hw_13_11_2022_string;

//@Khvostov

/*write a program that asks user to enter a word.
  If the work starts with x, replace it with a.
                        Input:
                            xcodex
                        Output:
                            acodex, replace*/

public class Task3 {
    public static void main(String[] args) {
        String word = null;

        if (word.startsWith("x")) {
            String result = word.replaceFirst("x", "a");

            System.out.println(result);
        }
    }
}
