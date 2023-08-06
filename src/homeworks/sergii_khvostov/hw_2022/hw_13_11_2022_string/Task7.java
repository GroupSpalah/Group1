package homeworks.sergii_khvostov.hw_2022.hw_13_11_2022_string;

//@Khvostov

/*Дано слово. Переставить первые три и последние три буквы,
  сохранив порядок их следования.*/


import java.util.Arrays;

public class Task7 {
    public static void main(String[] args) {
        String word = "lopFFFpop";

        String firstThree = word.substring(0, 3);
        String lastThree = word.substring(word.length() - 3);

        String[] middle1 = word.split(firstThree);
        String[] middle = middle1[1].split(lastThree);

        String middleStr = Arrays.toString(middle);

        StringBuilder str = new StringBuilder();

        StringBuilder result = str.append(lastThree).append(middleStr).append(firstThree);

        System.out.println(result);



    }
}
