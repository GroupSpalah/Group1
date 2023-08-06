package homeworks.dmytro_m.hw_2022.hw_13_11_2022;

public class Test7 {

    public static void main(String[] args) {
        String str = "Dmitro";
        dividingWordIntoPieces(str);
    }

    public static void dividingWordIntoPieces(String str) {
        String sub1 = str.substring(0, 3);
        String sub2 = str.substring(str.length() - 3);
        System.out.println(sub2 + sub1);
    }

}
// 7)  Дано слово. Переставить первые три и последние три буквы, сохранив порядок их следования.
//
////See solutions