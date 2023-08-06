package homeworks.sergii_khvostov.hw_2022.hw_13_11_2022_string;

//@Khvostov

/*Ask user to enter two words. Print first word without its first character
  then print the second word without its first character.
         Input:
          apple
          banana
         Output:
          ppleanana*/

public class Task4 {
    public static void main(String[] args) {

        String word1 = "apple";
        String word2 = "bannana";

        String withoutWord1 = word1.substring(1);
        String withoutWord2 = word2.substring(1);
        String result = withoutWord1.concat(withoutWord2);

        System.out.println(result);
    }
}
