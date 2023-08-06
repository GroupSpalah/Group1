package homeworks.dmytro_m.hw_2022.hw_06_11_2022;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        String str1 = "Cartoon".toLowerCase();
        String str2 = "Cat".toLowerCase();

        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            String s = String.valueOf(c);

            if(!str2.contains(s)) {
                System.out.println(s);
            }
        }

    }
}
//Объявите две локальные переменные myStr1 и myStr2 типа String и
//присвойте первой строке значение «Cartoon».
//и «Кот» для второго.
//Напишите код для отображения всех букв, которые присутствуют в первом слове, но отсутствуют во втором.
//    public static void main(String[] args) {
//
//        String myStr1 = "Cartoon".toLowerCase();
//        String myStr2 = "Tomcat".toLowerCase();
//
//        for (int i = 0; i < myStr1.length(); i++) {
//            String charAsString = String.valueOf(myStr1.charAt(i));
//
//            if (!myStr2.contains(charAsString)) {
//                System.out.print(charAsString + "\t");
//            }
//        }
//    }