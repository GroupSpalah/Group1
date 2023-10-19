package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EventOrganizerCompanySrvice {
    private List<Employee> staff;

    public EventOrganizerCompanySrvice() {
        this.staff = new LinkedList<>();
    }
    public void addEmployeeToStaff(Employee employee) {
        this.staff.add(employee);
    }
    public List<Employee> getStaff() {
        return this.staff;
    }
    private Event assignStaffToEvent(Event event) {
        List<Employee> orgnizers = this.staff
                .stream().filter(e -> e.getRole() == Role.ORGANIZER)
                .sorted((a,b) -> new Random().nextInt(3) - 2)
                .limit(3)
                .collect(Collectors.toList());
        Employee employee = assignMainOrganizer(orgnizers);
        event.setMainOrganizer(employee);
        int index = orgnizers.indexOf(employee);
        orgnizers.set(index, employee);
        List<Employee> assistants = this.staff
                .stream()
                .filter(e -> e.getRole() == Role.ASSISTENT)
                .sorted((a,b) -> new Random().nextInt(3) - 2)
                .limit(10)
                .collect(Collectors.toList());
        List<Employee> eventOrganizers = new ArrayList<>(orgnizers);
        eventOrganizers.addAll(assistants);
        event.setOrganizers(eventOrganizers);
        return event;
    }
        private Employee assignMainOrganizer(List<Employee> oganizers) {
        Employee mainOrganizer = oganizers.get(new Random().nextInt(2));
        mainOrganizer.setRole(Role.MAIN_ORGANIZER);
        int index = this.staff.indexOf(mainOrganizer);
        Employee employee = this.staff.get(index);
        int newMainOrganizerCount = employee.getMainOrganizerEventsCount() + 1;
        employee.setMainOrganizerEventsCount(newMainOrganizerCount);
        this.staff.set(index, employee);
        return employee;
    }
    public Event createEvent(Event event) {
        return assignStaffToEvent(event);
    }

    public Employee getTheBestOrganizer() {
        return this.staff.stream()
                .filter(e -> e.getRole() == Role.ORGANIZER)
                .max((a,b) -> a.getMainOrganizerEventsCount() - b.getMainOrganizerEventsCount()).get();
    }

}
