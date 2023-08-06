package homeworks.dmytro_m.hw_2022.hw_11_12_2022;

import java.util.regex.Pattern;

public class RegexTest3 {
    public static void main(String[] args) {
        String name= "Dmytro Mitusov";
        String template = "[A-Z][a-z]+\\s[A-Z][a-z]+";
        System.out.println(Pattern.matches(template, name));


    }
}
//        3) Пользователь вводит имя и фамилию. Буквы могут быть в разных регистрах.
//        Проверить, чтобы первые буквы были в верхнем регистре, а остальные буквы - в нижнем.