package homeworks.dmytro_m.hw_2022.hw_06_11_2022;

public class Test2 {

    public static void main(String[] args) {
        System.out.println(sub("qwerty"));
    }

    public static String sub(String str) {
        return str.substring(0, str.length()/2);
    }
}
//Дано слово, состоящее из четного числа букв.
//Вывести на экран его первую половину, не используя оператор цикла., substring