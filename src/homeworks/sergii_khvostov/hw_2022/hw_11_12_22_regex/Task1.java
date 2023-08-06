package homeworks.sergii_khvostov.hw_2022.hw_11_12_22_regex;

/*1) Любое количество букв, а потом две цифры и наоборот.*/

import java.util.regex.Pattern;

public class Task1 {
    public static void main(String[] args) {
        String text = "AJJsfesvf33";
        String template = "[A-Za-z]+(\\d{2})";
        System.out.println(Pattern.matches(template, text));

        String textReverse = "56Ajbhjb";
        String temlateReverse = "\\d{2}[A-Za-z]+";
        System.out.println(Pattern.matches(temlateReverse, textReverse));
    }
}
