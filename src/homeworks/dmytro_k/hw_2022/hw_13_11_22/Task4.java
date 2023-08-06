package homeworks.dmytro_k.hw_2022.hw_13_11_22;

/*4)Ask user to enter two words. Print first word without its first character
  then print the second word without its first character.
                                          Input:
                                              apple
                                              banana
                                          Output:
                                              ppleanana
 */

public class Task4 {

    public static void main(String[] args) {

        String word1 = "apple";

        String word2 = "banana";

        String newWord = word1.substring(1) + word2.substring(1);

        System.out.println(newWord);
    }
}
