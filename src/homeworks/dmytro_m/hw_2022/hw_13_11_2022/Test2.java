package homeworks.dmytro_m.hw_2022.hw_13_11_2022;

public class Test2 {

    public static void main(String[] args) {
        String s1 = "www.facbook.com";
        System.out.println(websiteCheck(s1));
    }

    public static boolean websiteCheck(String s) {
        boolean b1 = s.startsWith("www");
        boolean b2 = s.endsWith(".com") || s.endsWith(".edu") || s.endsWith(".gov");
        return b1 && b2;
    }
}
//    написать программу, которая может проверить, является ли данный веб-сайт действительным веб-сайтом или нет
//        начинается с: : www.
//        заканчивается с: .com, .edu, .gov, startsWith, endsWith
