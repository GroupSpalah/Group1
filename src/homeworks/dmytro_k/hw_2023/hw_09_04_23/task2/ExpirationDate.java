package homeworks.dmytro_k.hw_2023.hw_09_04_23.task2;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

/**
 * 2. Разработать программу для оператора мобильной связи, позволяющую
 * для отдельно введенных значений даты и времени последнего исходящего
 * звонка определить дату и время истечения срока действия данного пакета
 * и какой это будет день недели (1 – понедельник). В условии договора
 * сказано, что пакет действует в течение 1 года после последнего исходящего звонка.
 **/

public class ExpirationDate {

    public static void main(String[] args) {

        LocalDateTime localDateTimeIn = LocalDateTime.of(2023, 12, 30, 21, 30, 52);

        LocalDateTime localDateTimeOut = localDateTimeIn.plusYears(1);

        DayOfWeek dayOfWeek = localDateTimeOut.getDayOfWeek();

        System.out.println("Package expires: " + localDateTimeOut);

        System.out.println(dayOfWeek);
    }
}
