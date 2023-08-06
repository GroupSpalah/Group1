package homeworks.sergii_khvostov.hw_2022.hw_20_11_22;

//@Khvostov

/*Посчитать количество углов в N треугольниках и K ромбах.
 * N и K передаются параметрами функции и 0 < N, K < 10000.
 * Функция возвращает суммарное количество углов.*/

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();

        System.out.println(task1.countsAngles(5, 5));
    }

    public int countsAngles(int n, int k) {
        int countAngles = 0;

        if (n > 0 && k < 10000) {
            countAngles = n + k;
        }
        return countAngles;
    }
}
