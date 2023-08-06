package homeworks.sergii_khvostov.hw_2023.hw_09_04_23;

/*Разработать программу для оператора мобильной связи, позволяющую
для отдельно введенных значений даты и времени последнего исходящего
звонка определить дату и время истечения срока действия данного пакета
и какой это будет день недели (1 – понедельник). В условии договора
сказано, что пакет действует в течение 1 года после последнего исходящего звонка.*/

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task2 {

    public static void main(String[] args) {

        LocalDateTime lastOutgoingCall =
                LocalDateTime.of(2022, 4, 10, 12, 32);

        LocalDateTime expirationDateTime = lastOutgoingCall.plusYears(1);

        DayOfWeek expirationDayOfWeek = expirationDateTime.getDayOfWeek();
        int expirationDayOfWeekValue = expirationDayOfWeek.getValue();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        System.out.println("Last outgoing call: " + formatter.format(lastOutgoingCall));
        System.out.println("Package expiration: " + formatter.format(expirationDateTime));
        System.out.println("Day of the week when the package expires: " + expirationDayOfWeekValue);

    }
}
