package lessons.dates;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class LearnDates {
    public static void main(String[] args) {
        Date date = new Date();

        System.out.println(date);

        Calendar instance = Calendar.getInstance();

        LocalDate localDate = LocalDate.now();

        LocalDate localDate1 = localDate.plusDays(5);
    }
}
