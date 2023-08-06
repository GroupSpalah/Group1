package homeworks.dmytro_k.hw_2022.hw_11_12_22;

/*3) Пользователь вводит имя и фамилию. Буквы могут быть в разных регистрах.
Проверить, чтобы первые буквы были в верхнем регистре, а остальные буквы - в нижнем.*/

import java.util.regex.Pattern;

public class Task3 {

    public static void main(String[] args) {

        String text = "Wghjkkg Hhgg";
        String template = "[A-Z][a-z]+\\s[A-Z][a-z]+";
        System.out.println(Pattern.matches(template, text));

    }
}
