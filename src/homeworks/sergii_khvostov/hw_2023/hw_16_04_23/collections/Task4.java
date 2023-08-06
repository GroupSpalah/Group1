package homeworks.sergii_khvostov.hw_2023.hw_16_04_23.collections;

/*В коллекции храним список стран. Вывести страны, которые содержут букву 'A'*/

import java.util.LinkedList;

public class Task4 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("USA");
        list.add("Ukraine");
        list.add("United Kingdom");
        list.add("Germany");
        list.add("Canada");
        list.add("Australia");
        list.add("Argentina");

        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);

            if (element.toLowerCase().contains("a")) {
                System.out.println(element);
            }
        }
    }
}
