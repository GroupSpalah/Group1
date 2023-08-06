package homeworks.sergii_khvostov.hw_2022.hw_11_12_22_regex;

/*2-4 цифры, а потом 2-4 буквы и наоборот.*/

import java.util.regex.Pattern;

public class Task2 {
    public static void main(String[] args) {
        String text = "5644jdnk";
        String template = "\\d{2,4}[A-Za-z]{2,4}";
        System.out.println(Pattern.matches(template, text));

        String textReverse = "Ab88";
        String templateReverse = "[A-Za-z]{2,4}\\d{2,4}";
        System.out.println(Pattern.matches(templateReverse, textReverse));
    }
}
