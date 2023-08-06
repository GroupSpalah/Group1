package homeworks.dmytro_m.hw_2022.hw_18_12_2022;

import java.util.regex.Pattern;

public class Regex2 {

    public static void main(String[] args) {

        String text = "o awd plk 43.43 432 eef r awd 89 .98 0.32";

//        Pattern pattern1 = Pattern.compile("\\d*");
//        Pattern pattern2 = Pattern.compile("[a-zA-Z]");
//        Pattern pattern3 = Pattern.compile("[a-zA-Z]{2,}");
//        Pattern pattern4 = Pattern.compile("[0-9]*?\\.[0-9]+");
        String patternInt = "\\d*";
        String patternChar = "[a-zA-Z]";
        String patternString = "[a-zA-Z]{2,}";
        String patternDouble = "[0-9]*?\\.[0-9]+";

        String[] words = text.split(" ");
        for (String word : words) {
            if (Pattern.matches(patternInt, word)) {
                System.out.println(word + " int");
            }
            if (Pattern.matches(patternChar, word)) {
                System.out.println(word + " char");
            }
            if (Pattern.matches(patternString, word)) {
                System.out.println(word + " String");
            }
            if (Pattern.matches(patternDouble, word)) {
                System.out.println(word + " double");
            }
        }

    }
}
//                2) Файл содержит символы, целые числа и числа с плавающей запятой.
//// Напишем класс со следующим функционалом: в цикле пользователь вводит тип данных (один из них: char, int, double, String),
//// в ответ приложение выводит в консоль все значения соответствующих типов, которые существуют в файле.
//// Если пользователь вводит слово «стоп», приложение выходит из цикла. В остальных случаях должно быть напечатано «Неверный ввод».
//// Решаем задачу с помощью регулярных выражений.
//<p>
//        Примечание. «Строкой» следует считать последовательность из двух и более символов.
//// Символы - буквы латиницы или кириллицы в верхнем или нижнем регистре (необходимо предусмотреть
//// что кириллические буквы могут быть во входном файле).
//
//                Example of the original file:
//                ————————————————————————-
//                a bcd 43.43 432 и л фвыа 89 .98