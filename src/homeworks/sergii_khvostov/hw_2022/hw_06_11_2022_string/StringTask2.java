package homeworks.sergii_khvostov.hw_2022.hw_06_11_2022_string;

//@Khvostov

/*Дано слово, состоящее из четного числа букв.
  Вывести на экран его первую половину, не используя оператор цикла.*/

public class StringTask2 {
    public static void main(String[] args) {

        String str = "word";

        System.out.println(str.substring(0, 2));
    }
}
