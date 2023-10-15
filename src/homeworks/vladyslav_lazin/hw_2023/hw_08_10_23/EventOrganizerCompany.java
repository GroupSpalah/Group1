package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.*;
import java.util.stream.Collectors;

public class EventOrganizerCompany {
    private static List<Organizer> organizers;
    private static List<Assistant> assistants;
    private static List<Event> events;

    public EventOrganizerCompany() {
        events = new ArrayList<>();
    }
    public List<Event> getEvents() {
        return events;
    }

    public static List<Organizer> getOrganizers() {
        return organizers;
    }

    public static void setOrganizers(List<Organizer> organizers) {
        EventOrganizerCompany.organizers = organizers;
    }

    public static List<Assistant> getAssistants() {
        return assistants;
    }

    public static void setAssistants(List<Assistant> assistants) {
        EventOrganizerCompany.assistants = assistants;
    }

    public void createEvent(Event event) {
        //TODO сделать добавление персонала в персонал события
        Organizer mainOrganizer = getMainOrganizer(event);
        int mainOrganizerCount = mainOrganizer.getMainOrganizerEventCount();
        int index = EventOrganizerCompany.getOrganizers().indexOf(mainOrganizer);
        Organizer organizer = EventOrganizerCompany.organizers.get(index);
        organizer.setMainOrganizerEventCount(mainOrganizerCount++);
        event.setMainOrganizer(mainOrganizer);
        events.add(event);
    }

    private Organizer getMainOrganizer(Event event) {
        List<Employee> organizers = event.getEventStaff().stream().filter(employee -> employee instanceof Organizer).toList();
        Random random = new Random();
        return (Organizer) organizers.get(random.nextInt(organizers.size()));
    }
}
