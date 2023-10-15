package homeworks.dmytro_k.hw_2023.hw_08_10_23.task1;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1) Since 24/09/23
 * ++- Сгруппировать людей по количеству детей.
 * ++- Сгруппировать людей по количеству детей и возрасту.
 * ++- Сгруппировать людей по городу и названию улицы.
 * - Сгруппировать людей по городу и названию улицы и вывести количество адресов, где количество людей больше 4.
 */

public class ManService {
    public void groupingByCountOfChildren(List<Man> people) {
        Map<Integer, List<Man>> map = people
                .stream()
                .collect(Collectors.groupingBy(man -> man.getCountOfChildren()));
    }

    public void groupingByCountOfChildrenAndAge(List<Man> people) {
        Map<ManGroupByAgeAndChildren, List<Man>> map = people
                .stream()
                .collect(Collectors
                        .groupingBy(man -> new ManGroupByAgeAndChildren(
                                man.getAge(),
                                man.getCountOfChildren())));
    }

    public void groupingByCityAndStreet(List<Man> people) {
        Map<ManGroupByCityAndStreet, List<Man>> map = people
                .stream()
                .collect(Collectors
                        .groupingBy(man -> new ManGroupByCityAndStreet(
                                man
                                        .getADDRESS()
                                        .getCity(),
                                man
                                        .getADDRESS()
                                        .getStreet())));
    }

    public void groupingByCityAndStreetAndAddressCount(List<Man> people) {
        Map<ManGroupByCityAndStreet, List<Man>> map = people
                .stream()
                .collect(Collectors
                        .groupingBy(man -> new ManGroupByCityAndStreet(
                                man
                                        .getADDRESS()
                                        .getCity(),
                                man
                                        .getADDRESS()
                                        .getStreet())));
    }
}
