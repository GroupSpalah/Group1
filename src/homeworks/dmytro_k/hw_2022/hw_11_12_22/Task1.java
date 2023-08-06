package homeworks.dmytro_k.hw_2022.hw_11_12_22;

/*1) Любое количество букв, а потом две цифры и наоборот.*/

import java.util.regex.Pattern;

public class Task1 {

    public static void main(String[] args) {

        String text = "Hearunrtllo12";
        String template = "[a-zA-Z]+\\d{2}";
        System.out.println(Pattern.matches(template, text));

        String text2 = "12Hearunrtllo";
        String template2 = "\\d{2}[a-zA-Z]+";
        System.out.println(Pattern.matches(template2, text2));
    }
}
