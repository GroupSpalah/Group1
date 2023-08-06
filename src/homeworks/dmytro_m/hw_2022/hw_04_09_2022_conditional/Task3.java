package homeworks.dmytro_m.hw_2022.hw_04_09_2022_conditional;

public class Task3 {
    public static void main(String[] args) {
        //        3) написать программу, которая может определять возрастные группы человека:
//        Teenager (< 21)
//        Adult   (>=21 && <55 )
//        Senior  ( > 55 )
//       если возраст отрицательный или больше 150, вывести недействительно
        int personYear = -1;
        if (personYear < 0 || personYear > 150) {
            System.out.println("недействительно");
        } else if (personYear >= 0 && personYear < 21) {
            System.out.println("Teenager");
        } else if (personYear >= 21 && personYear <= 55) {
            System.out.println("Adult");
        } else if (personYear > 55) {
            System.out.println("Senior");
        }
    }
}
