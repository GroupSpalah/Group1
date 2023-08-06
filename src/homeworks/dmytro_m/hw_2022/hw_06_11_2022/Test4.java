package homeworks.dmytro_m.hw_2022.hw_06_11_2022;

public class Test4 {

    public static void main(String[] args) {

        System.out.println(removeFirstChar("Hello"));
    }

    public static String removeFirstChar(String s) {
        return s.substring(1);
    }
}
//В заданной строке удалить первый символ., substring