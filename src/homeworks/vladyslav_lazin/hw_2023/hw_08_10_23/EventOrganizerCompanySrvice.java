package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EventOrganizerCompanySrvice {
    private List<Employee> staff;

    public EventOrganizerCompanySrvice() {
        this.staff = new ArrayList<>();
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
        private Event assignMainOrganizer(Event event) {
            List<Employee> organizers = event.getOrganizers().stream()
                .filter(element -> element.getRole() == Role.ORGANIZER)
                .collect(Collectors.toList());
            Collections.shuffle(organizers);
            Employee mainOrganizer = organizers.get(0);
            int index = event.getOrganizers().indexOf(mainOrganizer);
            mainOrganizer = event.getOrganizers().get(index);
            incrementMainOrganizerCount(mainOrganizer);
            mainOrganizer.setRole(Role.MAIN_ORGANIZER);
            event.getOrganizers().set(index, mainOrganizer);

        return event;
    }

    private void incrementMainOrganizerCount(Employee mainOrganizer) {
        int index = this.staff.indexOf(mainOrganizer);
        int mainOrganizerEventsCount = this.staff.get(index).mainOrganizerEventsCount;
        Employee organizer = this.staff.get(index);
        organizer.setMainOrganizerEventsCount(++mainOrganizerEventsCount);
        this.staff.set(index, organizer);
    }

    public Event organizeEvent(Event event) {
        event = assignStaffToEvent(event);
        event = assignMainOrganizer(event);
        return event;

    }

    public Employee getTheBestOrganizer() {
        return this.staff.stream()
                .filter(e -> e.getRole() == Role.ORGANIZER)
                .max((a,b) -> a.getMainOrganizerEventsCount() - b.getMainOrganizerEventsCount()).get();
    }

}
