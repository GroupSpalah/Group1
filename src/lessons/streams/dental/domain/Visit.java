package lessons.streams.dental.domain;

import java.time.LocalDate;

public class Visit {
    private LocalDate date;

    public Visit(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Visit" +
                "date=" + date ;
    }
}
