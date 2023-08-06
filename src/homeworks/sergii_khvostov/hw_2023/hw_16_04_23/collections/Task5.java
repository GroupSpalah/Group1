package homeworks.sergii_khvostov.hw_2023.hw_16_04_23.collections;

/*В коллекции храним список стран. Вывести страны, в которых больше 5 букв*/

import java.util.LinkedList;

public class Task5 {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("USA");
        list.add("Ukraine");
        list.add("United Kingdom");
        list.add("Germany");
        list.add("Canada");
        list.add("Australia");
        list.add("Argentina");
        list.add("Czech");

        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);

            if (element.length() == 5) {
                System.out.println(element);
            }
        }
    }
}
