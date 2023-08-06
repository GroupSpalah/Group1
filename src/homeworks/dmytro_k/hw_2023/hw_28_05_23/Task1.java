package homeworks.dmytro_k.hw_2023.hw_28_05_23;

/**
 * 1) В Map<String, Integer> хранить данные(Город, количество улиц)
 * вывести на печать(в отдельных методах):
 * - названия городов длина которых больше 5.
 * - названия городов, которые заканчиваются на определенную букву
 * и количество улиц больше 15.
 */

import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        Map<String, Integer> map = Map.of(
                "Lviv", 15,
                "Kyiv", 25,
                "Kharkiv", 8,
                "Chernihiv", 8,
                "Poltava", 8
        );

        m1(map);

        m2(map, "v");
    }

    public static void m1(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int keyLength = entry.getKey().length();

            if (keyLength > 5) {
                System.out.println(entry.getKey());
            }
        }
    }

    public static void m2(Map<String, Integer> map, String suffix) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            if (entry.getValue() > 15 && entry.getKey().endsWith(suffix)) {
                System.out.println(entry.getKey());
            }
        }
    }
}
