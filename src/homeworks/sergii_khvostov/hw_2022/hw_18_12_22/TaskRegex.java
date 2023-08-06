package homeworks.sergii_khvostov.hw_2022.hw_18_12_22;

import java.util.Arrays;

/*В строке содержутся слова и числа.
 Необходимо выделить числа и посчитать их сумму.*/
public class TaskRegex {
    public static void main(String[] args) {
        String word = "ex99ex99";

        String regexWord = "[A-Za-z]+";

        String[] arr = word.split(regexWord);

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            try {
                int number = Integer.parseInt(arr[i]);
                sum += number;
            } catch (NumberFormatException ignored) {
            }
        }
        System.out.print(sum);
    }
}

