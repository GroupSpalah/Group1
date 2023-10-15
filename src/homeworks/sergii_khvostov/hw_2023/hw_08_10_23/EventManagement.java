package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

/*В компании по организации мероприятий есть два типа сотрудников: организаторы и помощники.
    Для каждого сотрудника мы знаем его имя. Штат мероприятия состоит не менее чем из 10 помощников,
    3 организаторов и один из организаторов назначается главным организатором. Если все условия соблюдены,
    событие может начаться. Вы не можете начать мероприятие без минимального количества персонала.
    Компания организует следующие мероприятия:

   коктейльные вечеринки

   свадьбы

   конференции

   На коктейльных вечеринках гости могут заказать коктейли из ограниченного количества.
   Свадьба может начаться только со свадебного торта.
   На конференциях гости могут попросить подарочную сумку, но только одну на каждого гостя.

   Мы хотим знать имя организатора, который был главным организатором
   больше всего событий.*/

import java.util.*;
import java.util.stream.Collectors;

public class EventManagement {
    private List<Event> events;

    public EventManagement(List<Event> events) {
        this.events = events;
    }
    public void manageEvents() {
        Map<String, Long> organizerCount = events.stream()
                .filter(this::canEventStart)
                .flatMap(event -> event.employees().stream())
                .filter(employee -> employee.role() == EmployeeRole.ORGANIZER)
                .collect(Collectors.groupingBy(Employee::name, Collectors.counting()));

        Optional<Map.Entry<String, Long>> topOrganizer = organizerCount.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue));

        topOrganizer.ifPresent(entry -> System.out.println("Top Organizer: " + entry.getKey()));
    }

    private boolean canEventStart(Event event) {
        EventType eventType = event.type();
        long helperCount = event.employees().stream()
                .filter(employee -> employee.role().equals(EmployeeRole.HELPER))
                .count();
        long organizerCount = event.employees().stream()
                .filter(employee -> employee.role().equals(EmployeeRole.ORGANIZER))
                .count();

        return switch (eventType) {
            case COCKTAIL_PARTY -> helperCount >= 10 && organizerCount >= 3;
            case WEDDING -> helperCount >= 10 && organizerCount >= 3 && event.hasCake();
            case CONFERENCE -> helperCount >= 10 && organizerCount >= 3 && event.hasBags();
        };
    }
}

