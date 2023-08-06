package homeworks.sergii_khvostov.hw_2022.hw_13_11_2022_string;

//@Khvostov

/*Ask user to enter two words. Then add them together and print.
  But if the last letter if the first word and the first letter
  of the last letter is the same, print that character once.

                     Input:
                         one
                         eight
                     Output:
                         oneight*/

public class Task5 {
    public static void main(String[] args) {

        String word1 = "one";
        String word2 = "eight";

        String result = word1.concat(word2);

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; ++j) {

                if (arr1[0] == arr2[arr2.length - 1]) {
                    System.out.println(arr1[0]);

                } else {
                    System.out.println(result);
                }
                return;
            }
        }
    }
}
