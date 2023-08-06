package homeworks.dmytro_k.hw_2022.hw_11_09_22_loops_arrays;

/*  2) Программа должна вывести первые 10 чисел, которые делятся на 3 или 4 без остатка,
    но цикл for выполняет итерацию от 1 до 100 (поэтому оператор break необходимо
    использовать после вывода 10 результатов).
    Результат должен выглядеть:
    3
    4
    …
    20 */

public class Task2 {

    public static void main(String[] args) {

        int count = 0;

        for (int i = 1; i < 100; i++) {
            if (i % 3 == 0 || i % 4 == 0) {
                System.out.println(i);
                count++;
            }

            if (i % 3 == 0 || i % 4 == 0) {
                System.out.println(i);
                count++;
            }
            if (count == 10) {
                break;
            }
        }
    }
}


