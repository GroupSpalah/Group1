package homeworks.dmytro_m.hw_2023.hw_09_04_2023;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

//1) Методы LocalDate:
//        - format
//        - minus
//        -  3 метода now
//        -  parse
//        -  plus
//        -  of
//        -  until
//        -  isAfter
//        -  isBefore
//        Методы LocalDateTime:
//        - atZone
//        - atOffset
//        - from
//        -  truncatedTo
//        -  range
public class TaskMethod {
    public static void main(String[] args) {
        LocalDate ldt = LocalDate.now();
        System.out.println("format");
        String s = ldt.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s1 = ldt.format(DateTimeFormatter.ISO_LOCAL_DATE);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM-dd-yyyy");
        String s4 = dateTimeFormatter.format(LocalDate.now());
        System.out.println(s4);
        System.out.println(s);
        System.out.println(s1);

        System.out.println("minus");

        LocalDate localDate = ldt.minusDays(10);
        LocalDate localDate1 = ldt.minusYears(5);
        System.out.println(localDate);
        System.out.println(localDate1);
        System.out.println("now");

        ZoneId zone = ZoneId.of("Australia/Darwin");
        LocalDateTime localDate2 = LocalDateTime.now(zone);
        System.out.println(localDate2);
        ZoneId zone1 = ZoneId.of("Africa/Harare");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zone1);
        System.out.println(zonedDateTime);
        Clock clock = Clock.systemDefaultZone();
        LocalDate localDate3 = LocalDate.now(clock);
        System.out.println(localDate3);

        System.out.println("parse");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("MMMM-dd-yyyy", Locale.ENGLISH);
        LocalDate localDate4 = LocalDate.parse("February-23-2019", dateTimeFormatter1);
        System.out.println(localDate4);

        System.out.println("plus");
        System.out.println(ldt.plusDays(100));
        System.out.println(ldt.plusYears(15));

        System.out.println("of");
        LocalDate localDate5 = LocalDate.of(2013, Month.AUGUST, 13);
        System.out.println(localDate5);
        LocalDate localDate6 = LocalDate.of(2013, 9, 13);
        System.out.println(localDate6);

        System.out.println("until");
        Period period = Period.between(localDate6, localDate5);
        System.out.println(period);
        System.out.println(localDate6.until(localDate5));
        Period until1 = localDate5.until(localDate6);
        System.out.println(until1);

        System.out.println("isAfter");
        System.out.println(localDate6.isAfter(localDate5));
        System.out.println("isBefore");
        System.out.println(localDate6.isBefore(localDate5));

        //        - atZone
//        - atOffset
//        - from
//        -  truncatedTo
//        -  range
        System.out.println("Методы LocalDateTime:");
        System.out.println("atZone");
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.of("Africa/Cairo"));
        System.out.println(zonedDateTime1);
        System.out.println(localDateTime.atOffset(ZoneOffset.UTC));
        System.out.println(LocalDateTime.from(localDateTime));

    }
}
