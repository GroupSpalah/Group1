package homeworks.dmytro_m.hw_2023.hw_16_04_2023.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "qwe", "qsd", "qxqc");
        list.replaceAll(s -> s.replace('q', 'i'));
        for (String s : list) {
            System.out.println(s);
        }
    }
}
//        Есть Лист со строками
//        Допустим 3 строки - "qwe" "qsd" "qxc"
//        Нам нужно в этом листе, не создавая новый лист, заменить букву q на букву i например
//
//        В коллекции храним список стран. Вывести страны, которые начинаются на 'A', startWith
//
//        В коллекции храним список стран. Вывести страны, которые заканчиваются на 'A', endsWith
//
//        В коллекции храним список стран. Вывести страны, которые содержут букву 'A'
//
//        В коллекции храним список стран. Вывести страны, в которых больше 5 букв
//
//        В коллекции храним числа. Увеличить каждый элемент на 5