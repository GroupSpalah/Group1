package homeworks.dmytro_k.hw_2022.hw_13_11_22;

/* 3) write a program that asks user to enter a word. If the work starts with x,
replace it with a.
                        Input:
                            xcodex
                        Output:
                            acodex, replace
 */

public class Task3 {

    public static void main(String[] args) {

        String word = "xcodex";

        if (word.startsWith("x")) {
            String newWord = word.replaceFirst("x", "a");
            System.out.println(newWord);
        } else {
            System.out.println(word);
        }
    }
}
