package homeworks.sergii_khvostov.hw_2022.hw_20_11_22;

//@Khvostov

/*Необходимо посчитать сумму двух чисел a и b.
  В метод передаётся два числа (-1000 < a, b < 1000),
  метод возвращает сумму этих чисел.
 */

public class Task2 {
    public static void main(String[] args) {
        System.out.println(sum(500, 500));

    }

    public static int sum(int a, int b) {
        int c = 0;
        if (a > (-1000) && b < 1000) {
            c = a + b;
        }
        return c;
    }
}
