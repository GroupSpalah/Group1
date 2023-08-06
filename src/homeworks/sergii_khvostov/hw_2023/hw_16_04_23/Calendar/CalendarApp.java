package homeworks.sergii_khvostov.hw_2023.hw_16_04_23.Calendar;

/*Организовать приложение календарь.
Приложение должно позволять:

1) Выводить текущее время и дату в нескольких тайм-зонах(на выбор), тайм-зона это параметр.
При выводе даты и времени выводить также события на данный день.
2) Создавать событие(отдельный класс) на конкретную дату и по требованию пользователя
 выводить список событий.*/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class CalendarApp {
    private final LocalDateTime currentTime;
    private final EventManager eventManager;

    public CalendarApp() {
        this.currentTime = LocalDateTime.now();
        this.eventManager = new EventManager();
    }

    public void printCurrentTimeInAllZones() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time: " + currentTime.format(formatter));

        ZoneId losAngelesZone = ZoneId.of("America/Los_Angeles");
        LocalDateTime losAngelesTime = LocalDateTime.now(losAngelesZone);
        System.out.println("Los Angeles time: " + losAngelesTime.format(formatter));

        ZoneId londonZone = ZoneId.of("Europe/London");
        LocalDateTime londonTime = LocalDateTime.now(londonZone);
        System.out.println("London time: " + londonTime.format(formatter));
    }

    public void addEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter event name: ");
        String name = scanner.nextLine();

        System.out.println("Enter event date (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());

        Event event = new Event(name, date);

        eventManager.addEvent(event);
        System.out.println("Event added");
    }

    public void printEventsForDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter date to show events for (yyyy-MM-dd): ");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        List<Event> eventsForDate = eventManager.getEventsForDate(date);

        if (eventsForDate.isEmpty()) {
            System.out.println("No events for this date");
        } else {
            System.out.println("Events for " + date + ":");

            for (Event event : eventsForDate) {
                System.out.println(event.getName());
            }
        }
    }

    public static void main(String[] args) {
        CalendarApp app = new CalendarApp();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Select option:");
            System.out.println("1. Show current time in all zones");
            System.out.println("2. Add event");
            System.out.println("3. Show events for date");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> app.printCurrentTimeInAllZones();
                case 2 -> app.addEvent();
                case 3 -> app.printEventsForDate();
                case 4 -> {
                    running = false;
                    System.out.println("Goodbye");
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}

