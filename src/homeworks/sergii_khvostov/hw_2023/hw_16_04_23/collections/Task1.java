package homeworks.sergii_khvostov.hw_2023.hw_16_04_23.collections;

/*Есть Лист со строками.
Допустим 3 строки - "qwe" "qsd" "qxc".
Нам нужно в этом листе, не создавая новый лист, заменить букву q на букву i*/

import java.util.LinkedList;


public class Task1 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("qwe");
        list.add("qsd");
        list.add("qxc");

        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            element = element.replace("q", "i");
            list.set(i, element);
        }
        System.out.println(list);
    }
}
