package homeworks.sergii_khvostov.hw_2023.hw_16_04_23.collections;

/*В коллекции храним числа. Увеличить каждый элемент на 5*/

import java.util.LinkedList;

public class Task6 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        list.add(20);

        for (int i = 0; i < list.size(); i++) {
            Integer element = list.get(i);
            element = element + 5;
            list.set(i, element);
        }
        System.out.println(list);
    }
}
