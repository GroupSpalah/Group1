package homeworks.dmytro_m.hw_2022.hw_11_12_2022;

import java.util.regex.Pattern;

public class RegexTest1 {

    public static void main(String[] args) {

        String str1 = "shsfs24";
        String template1 = "[a-zA-Z]+\\d{2}";
        System.out.println(Pattern.matches(template1, str1));

        String str2 = "13dskrbgs";
        String template2 = "\\d{2}[a-zA-Z]+";
        System.out.println(Pattern.matches(template2, str2));

    }
}
//        1) Любое количество букв, а потом две цифры и наоборот.

//        5) Car numbers
//
//        !!! Class matcher