package homeworks.dmytro_k.hw_2023.hw_16_04_23.task1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Организовать приложение календарь.
 * Приложение должно позволять:
 * <p>
 * 1) Выводить текущее время и дату в нескольких тайм-зонах(на выбор), тайм-зона это параметр.
 * При выводе даты и времени выводить также события на данный день.
 **/

public class MyCalendar {
    public static void main(String[] args) {

        Event event = new Event(LocalDateTime.of(2023, 4, 22, 17, 40),
                "Some event");
        Event event2 = new Event(LocalDateTime.of(2023, 4, 23, 17, 40),
                "Some event2");
        Event event3 = new Event(LocalDateTime.of(2023, 4, 24, 17, 40),
                "Some event3");

        int zoneNumb = getNumberOfZone();

        String timeZone = "";

        if (zoneNumb >= 0) {
            timeZone = "UTC+" + zoneNumb;
        } else {
            timeZone = "UTC" + zoneNumb;
        }

        LocalDateTime now = LocalDateTime.now(ZoneId.of(timeZone));

        String time = now.format(DateTimeFormatter.ISO_LOCAL_TIME);
        System.out.println(time);

        String date = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(date);

        event.eventToday(date);
        event2.eventToday(date);
        event3.eventToday(date);
    }

    public static int getNumberOfZone() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a timezone from -12 to 12: ");

        boolean isNumb = scanner.hasNextInt();

        if (isNumb) {

            int number = scanner.nextInt();

            if (number >= -12 && number <= 12) {
                return number;
            } else {
                System.out.println("Input error. Retype.");
            }

        } else {
            System.out.println("Input error. Retype.");
        }
        return getNumberOfZone();
    }
}
