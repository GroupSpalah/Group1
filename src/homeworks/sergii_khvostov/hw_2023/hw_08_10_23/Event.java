package homeworks.sergii_khvostov.hw_2023.hw_08_10_23;

import java.util.ArrayList;
import java.util.List;

public abstract class Event {
    private EventType type;
    private List<Employee> employees;

    static List<Event> events = new ArrayList<>();//remove


    public Event(EventType type, List<Employee> employees) {
        this.type = type;
        this.employees = employees;
    }

    public EventType getType() {
        return type;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public abstract boolean canEventStart();

    public void addEvent() {
        if (canEventStart()) {
            events.add(this);
        } else {
            System.out.println("Event cannot be added: " + type);
        }
    }
}
