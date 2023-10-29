package homeworks.dmytro_k.hw_2023.hw_08_10_23.task2;

/**
 * ++Мы хотим знать имя организатора, который был главным организатором
 * больше всего событий.
 */

import java.util.*;
import java.util.stream.Collectors;

public class EventManagement {

    private List<Event> events;

    public EventManagement() {
        this.events = new ArrayList<>();
    }


    public void add(Event event) {//если старт, то эдд
        if (event.isStart()) {
            events.add(event);
        }
    }

    public void topOrganizer() {
        Map<String, Long> countTopOrganizer = events
                .stream()
                .flatMap(event -> event.getEmployees()
                        .stream()
                        .filter(employee -> employee.employeeType() == EmployeeType.MAIN_ORGANIZER))
                .collect(Collectors
                        .groupingBy(Employee::name, Collectors.counting()));
        countTopOrganizer
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(stringLongEntry -> System.out.println("Top organizer: " + stringLongEntry.getKey()));
    }
}
