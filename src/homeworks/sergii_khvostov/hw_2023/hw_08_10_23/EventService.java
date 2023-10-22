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
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EventService {
    private List<Event> events = new ArrayList<>();
    private List<Employee> employees;

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void manageEvents() {
        Map<String, Long> organizerCount = events.stream()
                .flatMap(event -> event.getEmployees().stream())
                .filter(employee -> employee.role() == EmployeeRole.ORGANIZER)
                .collect(Collectors.groupingBy(Employee::name, Collectors.counting()));

        Optional<Map.Entry<String, Long>> topOrganizer = organizerCount.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue));

        topOrganizer.ifPresent(entry -> System.out.println("Top Organizer: " + entry.getKey()));
    }

    private boolean canEventStart(Event event) {
        EventType eventType = event.getType();
        long helperCount = event.getEmployees().stream()
                .filter(employee -> employee.role().equals(EmployeeRole.HELPER))
                .count();
        long organizerCount = event.getEmployees().stream()
                .filter(employee -> employee.role().equals(EmployeeRole.ORGANIZER))
                .count();

        Map<EventType, Predicate<Event>> eventRules = Map.of(
                EventType.COCKTAIL_PARTY, e -> helperCount >= 10 && organizerCount >= 3,
                EventType.WEDDING, e -> helperCount >= 10 && organizerCount >= 3 &&
                        ((Wedding) e).hasCake(),
                EventType.CONFERENCE, e -> helperCount >= 10 && organizerCount >= 3 &&
                        ((Conference) e).hasBag());

        return eventRules.get(eventType).test(event);
    }

    public void addEvent(Event event) {
        if (canEventStart(event)) {
            events.add(event);
        } else {
            System.out.println("Event cannot be added: " + event.getType());
        }

    }
}

