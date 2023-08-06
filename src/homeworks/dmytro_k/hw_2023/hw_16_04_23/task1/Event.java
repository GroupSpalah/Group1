package homeworks.dmytro_k.hw_2023.hw_16_04_23.task1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Event {

    private LocalDateTime localDateTimeIn;
    private String event;

    public Event(LocalDateTime localDateTimeIn, String event) {
        this.localDateTimeIn = localDateTimeIn;
        this.event = event;
    }

    public LocalDateTime getLocalDateTimeIn() {
        return localDateTimeIn;
    }

    public void eventToday(String date) {

        String eventDate = getLocalDateTimeIn().format(DateTimeFormatter.ISO_LOCAL_DATE);

        if (date.equals(eventDate)) {
            System.out.println(event);
        }
    }
}
