package homeworks.sergii_khvostov.hw_2022.hw_06_11_2022_string;

//@Khvostov

/*Вывести текст, составленный из последних букв всех слов.*/

public class StringTask1 {
    public static void main(String[] args) {
        String str = "My name is Sergii";

        String[] words = str.split(" ");

        for (String word : words) {
            int index = word.length() - 1;
            System.out.print(word.charAt(index) + "\t");
        }
    }
}
