package homeworks.vladyslav_lazin.hw_2023.hw_08_10_23;

import java.util.List;

public abstract class Event {
    private List<Employee> organizers;
    private Employee mainOrganizer;

    public void setMainOrganizer(Employee mainOrganizer) {
        this.mainOrganizer = mainOrganizer;
    }

    public void setOrganizers(List<Employee> organizers) {
        this.organizers = organizers;
    }

    public Employee getMainOrganizer() {
        return mainOrganizer;
    }

    @Override
    public String toString() {
        return "Event{" +
                "organizers=" + organizers +
                '}';
    }
}
