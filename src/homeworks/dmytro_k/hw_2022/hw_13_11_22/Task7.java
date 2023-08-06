package homeworks.dmytro_k.hw_2022.hw_13_11_22;

/*7)  Дано слово. Переставить первые три и последние
три буквы, сохранив порядок их следования.*/

public class Task7 {

    public static void main(String[] args) {

        String word = "123111456";

        String firstLetters = word.substring(0, 3);

        String lastLetters = word.substring(word.length() - 3);

        String otherLetters = word.substring(3, word.length() - 3);

        String newWord = lastLetters + otherLetters + firstLetters;

        System.out.println(newWord);
    }
}
