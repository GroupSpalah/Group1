package lessons.streams;

import java.util.Map;
import java.util.stream.Stream;

/**
 * Let the key of Map is project name and value contains list of participants.
 * Create a Stream<String> nameList(Map<String, Stream<String>> map)
 * method of the MyUtils class to build sorted stream of all participants without duplication.
 * Please ignore null or empty strings, extra spaces and case sensitivity.
 * Throw NullPointerException if map is null.
 * For example, for a given map
 * {"Desktop"=[" iVan", "PeTro ", " Ira "], "Web"=["STepan", "ira ",
 * " Andriy ", "an na"], "Spring"=["Ivan", "Anna"]}
 * you should get
 * ["Andriy", "Anna", "Ira", "Ivan", "Petro ", "Stepan"]
 */
public class PhonesMap {
    public static void main(String[] args) {
        Map<String, Stream<String>> map = Map.of(
                "Desktop", Stream.of(" iVan", "PeTro ", " Ira "),
                "Web", Stream.of("STepan", "ira ", " Andriy ", "an na"),
                "Spring", Stream.of("Ivan", "Anna")
        );

        nameList(map)
                .forEach(System.out::println);
    }

    public static Stream<String> nameList(Map<String, Stream<String>> map) {
        return map
                .values()
                .stream()
                .flatMap(v -> v)
                .map(name -> {
                    String trimName = name.replaceAll(" ", "");

                    char firstSymbol = trimName.charAt(0);

                    String upperFirstSymbol = String.valueOf(firstSymbol).toUpperCase();

                    String lowerCase = trimName.substring(1).toLowerCase();

                    return upperFirstSymbol.concat(lowerCase);

                })
                .distinct();

    }
}
