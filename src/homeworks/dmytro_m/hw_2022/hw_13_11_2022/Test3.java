package homeworks.dmytro_m.hw_2022.hw_13_11_2022;

public class Test3 {

    public static void main(String[] args) {
        String str = "qwex";
        System.out.println(replacesTheFirstChar(str));
    }

    public static String replacesTheFirstChar(String str) {
        String firstStr = str.substring(0, 1).replace('x', 'a');
        String lastStr = str.substring(1);
        return firstStr + lastStr;
    }
}

//         написать программу, которая просит пользователя ввести слово.
//         Если произведение начинается с х, замените его на а.
////        Вход:
//        xcodex
//        Output:
//        acodex, replace