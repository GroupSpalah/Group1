package lessons.maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Подсчет количества слов в предложении
 */
public class Task1 {
    public static void main(String[] args) {
        String sentence = "Hello my young friend my friend";

        String[] words = sentence.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) {
                Integer value = map.get(word);

                map.put(word, ++value);
            } else {
                map.put(word, 1);
            }
        }

        System.out.println(map);
    }
}
