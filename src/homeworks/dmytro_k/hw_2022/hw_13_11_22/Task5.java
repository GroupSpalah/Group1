package homeworks.dmytro_k.hw_2022.hw_13_11_22;

/*  5) Ask user to enter two words. Then add them together and print.
         But if the last letter in the first word and the first letter
         of the last word is the same, print that character once.
                     Input:
                         one
                         eight
                     Output:
                         oneight*/

public class Task5 {

    public static void main(String[] args) {

        String word1 = "one";

        String word2 = "eight";

        for (int i = word1.length() - 1, j = 0; i < word1.length(); i++, j++) {

            char lastLetter = word1.charAt(i);
            char firstLetter = word2.charAt(j);

            if (lastLetter == firstLetter) {
                System.out.println(word1 + word2.substring(1));
            } else {
                System.out.println(word1 + word2);
            }
        }
    }
}
