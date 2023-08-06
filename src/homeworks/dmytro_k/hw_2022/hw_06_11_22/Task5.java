package homeworks.dmytro_k.hw_2022.hw_06_11_22;

/* *** В заданной строке удалить первый символ.*/

public class Task5 {
    public static void main(String[] args) {

        String word = "word";

        String newWord = word.substring(1);

        System.out.println(newWord);
    }
}
