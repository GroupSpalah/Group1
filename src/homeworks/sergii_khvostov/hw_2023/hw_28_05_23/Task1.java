package homeworks.sergii_khvostov.hw_2023.hw_28_05_23;

/*В Map<String, Integer> хранить данные(Город, количество улиц) вывести на печать(в отдельных методах):
   - названия городов длина которых больше 5.
   - названия городов, которые заканчиваются на определенную букву и количество улиц больше 150.*/

import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();

        Map<String, Integer> cities = Map.of(
                "Kharkov", 200,
                "Kiev", 300,
                "Dnepr", 170,
                "Odessa", 150,
                "Lviv", 140
        );

        task1.haveToDoMoreFive(cities);
        System.out.println();

        task1.shouldEndOnALetterAAndNoMore150(cities);

    }

    public void haveToDoMoreFive(Map<String, Integer> cities) {
        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
            if (entry.getKey().length() > 5) {
                System.out.println(entry.getKey());
            }
        }
    }

    public void shouldEndOnALetterAAndNoMore150(Map<String, Integer> cities) {
        for (Map.Entry<String, Integer> entry : cities.entrySet()) {
            if (entry.getKey().endsWith("v") && entry.getValue() > 150) {
                System.out.println(entry.getKey());
            }
        }
    }
}
