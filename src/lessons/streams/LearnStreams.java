package lessons.streams;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LearnStreams {
    public static void main(String[] args) {
        List<Integer> list = List.of(7, 4, 10, 6, 9, 3, 2);

        Predicate<Integer> predicate = element -> element > 5;

        Consumer<Integer> consumer = element -> System.out.println(element);

        list
                .stream()// List -> Stream, all elements
                .filter(predicate)//filtered stream
                .forEach(consumer);

    }
}

