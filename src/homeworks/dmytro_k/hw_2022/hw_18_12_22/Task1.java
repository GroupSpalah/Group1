package homeworks.dmytro_k.hw_2022.hw_18_12_22;

/*1) В строке содержутся слова и числа. Необходмо выделить числа и посчитать их сумму.*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.*;

public class Task1 {

    public static void main(String[] args) {

        String someString = "hello 10 4 5 worl16d";

        System.out.println(resolve(someString));
    }

    public static int resolve(String string) {

        String[] elements = string.split("\\D+");

        Pattern pattern1 = Pattern.compile("\\d");
        Matcher matcher1 = pattern1.matcher(string);

        int sum = 0;

        for (String element : elements) {

            try {
                int number = parseInt(element);
                sum += number;
            } catch (NumberFormatException ignored) {
            }
        }

        while (matcher1.find()) {

            int number = Integer.parseInt(matcher1.group());
            //int number = Integer.getInteger();
            sum += number;

        }

        return sum;
    }
}




