package lessons.maps;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LearnMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");

//        System.out.println(map);

        String valueTwo = map.get(2);

//        System.out.println(valueTwo);

        Set<Integer> keys = map.keySet();

        Collection<String> values = map.values();


    }
}
