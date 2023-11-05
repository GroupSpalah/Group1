package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

import java.util.List;

public abstract class Event {
    private EventType type;
    private List<Employee> employees;

    public Event(EventType type) {
        this.type = type;
        this.employees = ListEmployees.addEmployee();
    }

    public EventType getType() {
        return type;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public abstract boolean canEventStart();

    public void addEvent() {
        EventService eventService = new EventService();
        if (canEventStart()) {
            eventService.getEvents().add(this);
        } else {
            System.out.println("Event cannot be added: " + type);
        }
    }
}
