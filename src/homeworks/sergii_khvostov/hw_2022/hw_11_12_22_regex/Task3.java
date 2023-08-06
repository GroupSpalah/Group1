package homeworks.sergii_khvostov.hw_2022.hw_11_12_22_regex;

/*Пользователь вводит имя и фамилию. Буквы могут быть в разных регистрах.
  Проверить, чтобы первые буквы были в верхнем регистре,
  а остальные буквы - в нижнем.*/

import java.util.regex.Pattern;

public class Task3 {
    public static void main(String[] args) {
        String text = "John Smith";
        String template = "[A-Z]{1}[A-Za-z]+\\s[A-Z]{1}[A-Za-z]+";

        boolean compare = Pattern.matches(template, text);

        if (compare) {
            System.out.println(text);
        } else System.out.println("Error enter");
    }
}
