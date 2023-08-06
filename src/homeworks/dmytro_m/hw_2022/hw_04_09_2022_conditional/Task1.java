package homeworks.dmytro_m.hw_2022.hw_04_09_2022_conditional;

public class Task1 {
    public static void main(String[] args) {
//        1) Написать логическое выражение для выбора коэффициента учета
//        стажа работы по специальности в конкурсе на бюджетные места.Если
//        стаж до 2 лет, то коэффициент равен 11, если стаж от 2 до 5 лет –12,
//        если больше 5 лет –13.
        int coefficient = 0;
        int year = 2;
        if(year < 2) {
            coefficient = 11;
        } else if (year >= 2 && year <= 5) {
            coefficient = 12;
        } else if(year > 5) {
            coefficient = 13;
        }
        System.out.println(coefficient);
    }
}
