package homeworks.sergii_khvostov.hw_2023.hw_09_04_23;

/*Вывести сообщение с информацией о текущей системной дате и времени.*/

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    public static void main(String[] args) {

        LocalDateTime currentDate = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

        System.out.println("Current date and time: " + formatter.format(currentDate));

    }
}
