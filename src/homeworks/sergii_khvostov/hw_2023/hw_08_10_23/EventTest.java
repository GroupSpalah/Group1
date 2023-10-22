package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

import java.util.List;

public class EventTest {
    public static void main(String[] args) {
        ListEmployees employee = new ListEmployees();
        List<Employee> employees = employee.addEmployee();

        EventService eventService = new EventService();
        eventService.setEmployees(employees);

        Event cocktailParty = new Event(EventType.COCKTAIL_PARTY, employees);
        eventService.addEvent(cocktailParty);

        Event weddingEvent = new Wedding(employees, true);
        eventService.addEvent(weddingEvent);

        eventService.manageEvents();


    }
}





