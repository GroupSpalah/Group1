package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.List;

public abstract class Event {
    private List<Employee> eventStaff;
    private Organizer mainOrganizer;

    public Event(List<Employee> eventStaff) {
        this.eventStaff = eventStaff;
    }

    public List<Employee> getEventStaff() {
        return eventStaff;
    }

    public void setEventStaff(List<Employee> eventStaff) {
        this.eventStaff = eventStaff;
    }

    public void setMainOrganizer(Organizer mainOrganizer) {
        this.mainOrganizer = mainOrganizer;
    }
}
