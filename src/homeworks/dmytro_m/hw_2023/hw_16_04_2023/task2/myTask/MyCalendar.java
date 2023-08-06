package homeworks.dmytro_m.hw_2023.hw_16_04_2023.task2.myTask;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class MyCalendar {
    private LocalDateTime myTime;

    public void getDateOfZone(String zone) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        ZoneId zoneId = ZoneId.of(zone);

        myTime = LocalDateTime.now();
        System.out.println("Current time and date " + myTime.format(formatter));

        myTime = LocalDateTime.now(zoneId);
        System.out.println("In the time zone " +  myTime.format(formatter));
    }
}
