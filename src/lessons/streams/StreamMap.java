package lessons.streams;

import java.util.List;
import java.util.function.Function;

public class StreamMap {
    public static void main(String[] args) {
        List<ManMap> list = List.of(
                new ManMap("John", 32),
                new ManMap("Jack", 30),
                new ManMap("Ben", 28)
        );

        Function<ManMap, ChildMap> function = m -> new ChildMap(m.name(), m.age());

        List<ChildMap> childMaps = list
                .stream()
                .map(function)
                .toList();
    }
}

record ChildMap(String name, int age) {

}
