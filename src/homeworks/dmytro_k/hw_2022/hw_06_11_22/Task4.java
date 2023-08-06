package homeworks.dmytro_k.hw_2022.hw_06_11_22;

/**** Declare two local variables myStr1 and myStr2 of String type and
 * assign a value “Cartoon” for first string and ”Tomcat” for second.
 *  Write code to display all of the letters, which are present in the
 *  first word, but absent in the second.
 */

public class Task4 {

    public static void main(String[] args) {

        String myStr1 = "Cartoon";

        String myStr2 = "Tomcat";

        nonRepeatingLetters(myStr1, myStr2);
    }

    public static void nonRepeatingLetters(String str1, String str2) {

        String str1LowerCase = str1.toLowerCase();

        String str2LowerCase = str2.toLowerCase();

        for (int i = 0; i < str1LowerCase.length(); i++) {

            char symbol = str1LowerCase.charAt(i);

            String stringFromChar = String.valueOf(symbol);

            if (!str2LowerCase.contains(stringFromChar)) {
                System.out.print(stringFromChar);
            }
        }
    }
}
