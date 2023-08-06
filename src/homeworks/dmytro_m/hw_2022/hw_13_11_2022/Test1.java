package homeworks.dmytro_m.hw_2022.hw_13_11_2022;

public class Test1 {

    public static void main(String[] args) {
        String name1 = "Sam Harris";
        String name2 = "patrick feeney";
        System.out.println(nameInitialization(name1));
        System.out.println(nameInitialization(name2));
    }

    public static String nameInitialization(String name) {
        String[] array = name.split(" ");
        String s1 = array[0].substring(0, 1);
        String s2 = array[1].substring(0, 1);
        return s1.toUpperCase() + "." + s2.toUpperCase();
    }
}

//    Напишите функцию для преобразования имени в инициалы.
//        Это ката строго состоит из двух слов с одним пробелом между ними.
//        На выходе должны быть две заглавные буквы с точкой, разделяющей их.
//        Это должно выглядеть так:
//        Sam Harris => S.H
//        patrick feeney => P.F
