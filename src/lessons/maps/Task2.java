package lessons.maps;

import java.util.Map;

/**
 * В Map<String, Integer> хранить данные(Город, количество улиц) вывести на печать(в отдельных методах):
 * - названия городов, в которых больше 10 улиц.
 * - названия городов длина которых больше 5.
 * - названия городов, которые заканчиваются на определенную букву и количество улиц больше 15.
 */
public class Task2 {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "Lviv", 15,
                "Kiev", 25,
                "Kharkiv", 8
        );
// * - названия городов, в которых больше 10 улиц.
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 10) {
                System.out.println(entry.getKey());
            }
        }

    }
}
