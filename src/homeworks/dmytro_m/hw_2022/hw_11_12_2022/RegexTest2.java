package homeworks.dmytro_m.hw_2022.hw_11_12_2022;

import java.util.regex.Pattern;

public class RegexTest2 {
    public static void main(String[] args) {
        String str1 = "3142fgdv";
        String template = "\\d{2,4}[a-zA-Z]{2,4}";
        System.out.println(Pattern.matches(template, str1));

        String str2 = "3142fgdv142";
        String template2 = "\\d{2,4}[a-zA-Z]{2,4}\\d{2,4}";
        System.out.println(Pattern.matches(template2, str2));
    }
}
//        2) 2-4 цифры, а потом 2-4 буквы и наоборот.