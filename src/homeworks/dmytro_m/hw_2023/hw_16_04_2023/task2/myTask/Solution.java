package homeworks.dmytro_m.hw_2023.hw_16_04_2023.task2.myTask;

public class Solution {
    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        myCalendar.getDateOfZone("Europe/Monaco");
//        for (String s: ZoneId.getAvailableZoneIds())
//            System.out.println(s);
    }
}
//    Организовать приложение календарь.
//        Приложение должно позволять:
//
//        1) Выводить текущее время и дату в нескольких тайм-зонах(на выбор), тайм-зона это параметр.
//        При выводе даты и времени выводить также события на данный день.
//        2) Создавать событи(отдельный класс) на конкретную дату и по требованию пользователя выводить список событий.