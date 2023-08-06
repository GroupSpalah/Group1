package homeworks.dmytro_k.hw_2022.hw_06_11_22;

/**** Count chars of strings placed in the even positions in the given array.
 * For example: array = {"Hello", "world", "from", "array"}
 the result will be 9: "Hello" length is 5 and "from" length is 4 "world"
 and "array" are skipped because they are on the odd positions.
 */

public class Task3 {

    public static void main(String[] args) {

        String[] array = {"Hello", "world", "from", "array"};

        int sumCharsEvenPositions = 0;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sumCharsEvenPositions += array[i].length();
            }
        }

        System.out.println(sumCharsEvenPositions);
    }
}
