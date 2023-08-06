package homeworks.dmytro_k.hw_2022.hw_11_12_22;

/*5) Car numbers*/

import java.util.regex.Pattern;

public class Task5 {

    public static void main(String[] args) {

        String carNumber = "A123BA";

        System.out.println(resolve(carNumber));
    }

    public static int resolve (String carNumber) {

        String template = "([ABCEHKMOPTXY])\\d{3}([ABCEHKMOPTXY]){2}";

        if (Pattern.matches(template, carNumber)) {
            return 100;
        }

        String[] AllLetterCarNumber = carNumber.split("\\d");

        int count = 0;

        for (String carNumberLetters: AllLetterCarNumber) {

            count += carNumberLetters.length();
        }

        return count;
    }
}
