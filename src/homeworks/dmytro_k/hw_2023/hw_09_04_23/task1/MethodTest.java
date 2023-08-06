package homeworks.dmytro_k.hw_2023.hw_09_04_23.task1;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * 1) Методы LocalDate:
 * - format ++
 * - minus ++
 * -  3 метода now ++
 * -  parse ++
 * -  plus ++
 * -  of ++
 * -  until ++
 * -  isAfter ++
 * -  isBefore ++
 * Методы LocalDateTime:
 * - atZone ++
 * - atOffset
 * - from
 * -  truncatedTo
 * -  range
 * <p>
 * Примеры кода использования методов. Получение из этих объектов, объект Date
 **/

public class MethodTest {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);

        System.out.println("format _______________");

        System.out.println(
                localDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + "\n" +
                        localDate.format(DateTimeFormatter.BASIC_ISO_DATE) + "\n" +
                        localDate.format(DateTimeFormatter.ISO_DATE));

        System.out.println("minus _______________");
        System.out.println(
                localDate.minus(2, ChronoUnit.YEARS) + "\n" +
                        localDate.minus(2, ChronoUnit.MONTHS) + "\n" +
                        localDate.minus(2, ChronoUnit.DAYS) + "\n" +
                        localDate.minus(3, ChronoUnit.CENTURIES));

        System.out.println("now _______________");
        LocalDate now1 = LocalDate.now(Clock.systemDefaultZone());
        LocalDate now2 = LocalDate.now(ZoneId.systemDefault());

        System.out.println(now1);
        System.out.println(now2);

        System.out.println("parse _______________");
        LocalDate localDate1 = LocalDate.parse("2007-12-03");
        LocalDate localDate2 = LocalDate.parse("2007-12-03", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println(localDate1);
        System.out.println(localDate2);

        System.out.println("plus _______________");
        LocalDate plus = localDate2.plus(2, ChronoUnit.CENTURIES);// ?? ввод без второго параметра

        System.out.println(plus);

        System.out.println("until _______________");
        Period until1 = localDate1.until(localDate);
        System.out.println(until1);

        System.out.println("until _______________");
        long until2 = localDate1.until(localDate, ChronoUnit.YEARS);
        System.out.println(until2);

        System.out.println("isAfter _______________");
        boolean after = localDate1.isAfter(localDate);
        System.out.println(after);

        System.out.println("isBefore _______________");
        boolean before = localDate1.isBefore(localDate);
        System.out.println(before);

        System.out.println("LocalDateTime _______________");

        LocalDateTime localDateTime1 = LocalDateTime.now();
        //LocalDateTime localDateTime2 = LocalDateTime.from();

        System.out.println(localDateTime1);
        //System.out.println(localDateTime2);

/*        Map<String, String> shortIds = ZoneId.SHORT_IDS;
        System.out.println(shortIds);*/

        System.out.println("atZone _______________");

        ZonedDateTime zonedDateTime = localDateTime1.atZone(ZoneId.systemDefault());
        ZonedDateTime zonedDateTime2 = localDateTime1.atZone(ZoneId.of("+3"));
        //ZonedDateTime zonedDateTime3 = localDateTime1.atZone(ZoneId.of("+3", ); //?? Map<String, String>

        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime2);


        System.out.println("atOffset _______________");

        OffsetDateTime offsetDateTime1 = localDateTime1.atOffset(ZoneOffset.ofHours(+1));
        OffsetDateTime offsetDateTime2 = localDateTime1.atOffset(ZoneOffset.UTC);

        System.out.println(offsetDateTime1);
        System.out.println(offsetDateTime2);
    }
}

