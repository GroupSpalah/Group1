package homeworks.dmytro_k.hw_2022.hw_18_12_22;

/*
?????
Файл содержит символы, целые числа и числа с плавающей запятой.
Напишите класс, который имеет следующий функционал: в цикле пользователь вводит тип данных (один из них: char, int, double, String),
в ответ приложение выводит на консоль все значения соответствующих типов, которые существуют в файле.
Если пользователь вводит слово «стоп», приложение выходит из цикла. В остальных случаях должно быть напечатано «Неверный ввод».
Решите задачу с помощью регулярных выражений.
<р>
Примечание. «Строкой» следует считать последовательность из двух и более символов.
Символы - буквы латинского или кириллического алфавита в верхнем или нижнем регистре (необходимо предусмотреть
что кириллические буквы могут быть во входном файле).

Example of the original file:
        ————————————————————————-
        a bcd 43.43 432 и л фвыа 89 .98
        ————————————————————————-
 */

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Task2 {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in).useDelimiter(System.lineSeparator())) {

            try (BufferedReader bufferedReader = new BufferedReader(

                    new InputStreamReader(new FileInputStream("part3.txt"), "UTF-8"))) {

                StringBuilder inputFromConsole = new StringBuilder();

                String dataFromFile = bufferedReader.readLine();

                String data = null;

                /*while (!(data = scanner.next()).equals("stop")) {
                    inputFromConsole.append(data).append("\n");
                }*/

                String[] words = dataFromFile.split("\\s");

                while (!(data = scanner.next()).equals("stop")) {

                    String regex = null;

                    switch (data) {
                        case "char":
                            regex = "[a-zа-яA-ZА-Я]{1}";
                            break;
                        case "int":
                            regex = "\\d*";
                            break;
                        case "double":
                            regex = "[0-9]*?[.][0-9]+";
                            break;
                        case "String":
                            regex = "[a-zа-яA-ZА-Я]{2,}";
                            break;
                    }

    //                System.out.println("Datatype = " + data);

                    for (int i = 0; i < words.length; i++) {

                        if (Pattern.matches(regex, words[i])) {
                            System.out.print(words[i] + "\t");
                        }
                    }

    //                System.out.println();

                }


                final Pattern pattern = Pattern.compile("\\d*");//int
    //            final Pattern pattern = Pattern.compile("[a-zа-яA-ZА-Я]{1}");//char
    //            final Pattern pattern = Pattern.compile("[0-9]*?[.][0-9]+");//double
    //        final Pattern pattern = Pattern.compile("[a-zа-яA-ZА-Я]{2,}");//String

            } catch (
                    IOException e) {
                e.printStackTrace();
            }
        }
    }
}

