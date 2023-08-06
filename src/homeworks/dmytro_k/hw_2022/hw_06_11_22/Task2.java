package homeworks.dmytro_k.hw_2022.hw_06_11_22;

/**** Дано слово, состоящее из четного числа букв. Вывести на экран
 * его первую половину, не используя оператор цикла. substring*/

public class Task2 {

    public static void main(String[] args) {

        String word = "word";

        String halfWord = word.substring(0, word.length() / 2);

        System.out.println(halfWord);
    }
}
