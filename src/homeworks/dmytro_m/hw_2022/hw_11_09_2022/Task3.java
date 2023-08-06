package homeworks.dmytro_m.hw_2022.hw_11_09_2022;


public class Task3 {
    public static void main(String[] args) {
//          Напишите программу, которая вычисляет сумму 1, 2, 3, ... до верхней границы - n.
////        Также вычисляем и отображаем среднее значение.
////        Вывод должен выглядеть так:
//          The Sum is: 100
//          The Avg is: 10
        int sum = 0;
        int n = 10;

        for (int i = 0; i < n; i++) {
            sum += i;
        }

       double avg = sum * 1.0 / n;
        System.out.println(avg);
    }
}
