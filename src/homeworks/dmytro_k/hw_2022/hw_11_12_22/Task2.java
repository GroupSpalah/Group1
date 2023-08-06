package homeworks.dmytro_k.hw_2022.hw_11_12_22;

/*2) 2-4 цифры, а потом 2-4 буквы и наоборот.*/

import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) {

        String text = "Hefa4412";
        String template = "[a-zA-Z]{2,4}\\d{2,4}";
        System.out.println(Pattern.matches(template, text));

        String text2 = "156YUkg";
        String template2 = "\\d{2,4}[a-zA-Z]{2,4}";
        System.out.println(Pattern.matches(template2, text2));
    }
}
