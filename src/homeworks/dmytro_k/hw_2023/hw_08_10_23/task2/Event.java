package homeworks.dmytro_k.hw_2023.hw_08_10_23.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * 2) Управление событиями
 * <p>
 * ++В компании по организации мероприятий есть два типа сотрудников: организаторы и помощники.
 * ++Для каждого сотрудника мы знаем его имя.
 * ++Штат мероприятия состоит не менее чем из 10 помощников, 3 организаторов и
 * ++один из организаторов назначается главным организатором.
 * ++Если все условия соблюдены, событие может начаться.
 * ++Вы не можете начать мероприятие без минимального количества персонала.
 * <p>
 * Компания организует следующие мероприятия:
 * <p>
 * ++коктейльные вечеринки (лист коктейли)
 * <p>
 * ++свадьбы
 * <p>
 * конференции
 * <p>
 * ++На коктейльных вечеринках гости могут заказать коктейли из ограниченного количества.
 * ++Свадьба может начаться только со свадебного торта.
 * На конференциях гости могут попросить подарочную сумку, но только одну на каждого гостя.
 * <p>
 * ++Мы хотим знать имя организатора, который был главным организатором
 * больше всего событий.
 */

public abstract class Event {
    public static final int COUNT_STAFF = 13;
    private List<Employee> employees;
    private EventType eventType;

    public Event(EventType eventType) {
        this.employees = new ArrayList<>();
        this.eventType = eventType;
    }

    private boolean containsMainOrganizer() {
        return employees
                .stream()
                .anyMatch(employee -> employee.employeeType().equals(EmployeeType.MAIN_ORGANIZER));
    }

    private boolean containsTwoOrganizer() {
        return employees
                .stream().filter(employee -> employee.employeeType().equals(EmployeeType.ORGANIZER))
                .count() == 2;
    }

    private boolean notContainsTwoMainOrganizer() {
        return employees
                .stream()
                .noneMatch(employee -> employee.employeeType().equals(EmployeeType.MAIN_ORGANIZER));
    }

    public void addEmployee(Employee employee) {
        if (employee.employeeType().equals(EmployeeType.MAIN_ORGANIZER)) {
            if (notContainsTwoMainOrganizer()) {
                employees.add(employee);
            } else {
                System.out.println("Еhe event already contains a main organizer.");
            }
        } else {
            employees.add(employee);
        }
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public boolean isStart() {//может ли начаться ивент
        return containsMainOrganizer() && containsTwoOrganizer() && employees.size() >= COUNT_STAFF;
    }
}
