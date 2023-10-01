package lessons.streams;

import java.util.ArrayList;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>(List.of(4, 7, 9));

        values
                .stream()
                .peek(v -> v *= 2)
                .forEach(System.out::println);
    }
}
