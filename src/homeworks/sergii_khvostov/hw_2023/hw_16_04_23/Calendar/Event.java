package homeworks.sergii_khvostov.hw_2023.hw_16_04_23.Calendar;

import java.time.LocalDate;

public class Event {

    private final String name;
    private final LocalDate date;

    public Event(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }
}
