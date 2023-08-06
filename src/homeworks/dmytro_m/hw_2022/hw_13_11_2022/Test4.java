package homeworks.dmytro_m.hw_2022.hw_13_11_2022;

public class Test4 {

    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        System.out.println(removeFirstCharacterWords(str1, str2));
    }

    public static String removeFirstCharacterWords(String first, String last) {
        return first.substring(1) + last.substring(1);
    }
}
//        4)Попросите пользователя ввести два слова. Вывести первое слово без первого символа
//// затем напечатайте второе слово без его первого символа.
//        Input:
//        apple
//        banana
//        Output:
//        ppleanana