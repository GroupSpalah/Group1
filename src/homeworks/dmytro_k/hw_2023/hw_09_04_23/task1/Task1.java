package homeworks.dmytro_k.hw_2023.hw_09_04_23.task1;

/*1. Вывести сообщение с информацией о текущей системной дате и времени.*/

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Task1 {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTime2 = LocalTime.now(Clock.systemDefaultZone());
        System.out.println(localTime2);
    }
}
