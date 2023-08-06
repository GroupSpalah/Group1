package homeworks.sergii_khvostov.hw_2023.hw_16_04_23.Calendar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private final List<Event> events = new ArrayList<>();

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEventsForDate(LocalDate date) {
        List<Event> eventsForDate = new ArrayList<>();

        for (Event event : events) {
            if (event.getDate().equals(date)) {
                eventsForDate.add(event);
            }
        }
        return eventsForDate;
    }
}
