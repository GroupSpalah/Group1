package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.List;

public abstract class Event {
    private List<Employee> organizers;
    public void setOrganizers(List<Employee> organizers) {
        this.organizers = organizers;
    }
    public Employee getMainOrganizer() {
        return this.organizers.stream()
                .filter(element -> element.getRole() == Role.MAIN_ORGANIZER)
                .findFirst().orElse(null);
    }

    public List<Employee> getOrganizers() {
        return organizers;
    }

    @Override
    public String toString() {
        return "Event{" +
                "organizers=" + organizers +
                '}';
    }
}
