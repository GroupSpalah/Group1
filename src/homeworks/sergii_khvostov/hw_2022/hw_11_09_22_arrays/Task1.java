package homeworks.sergii_khvostov.hw_2022.hw_11_09_22_arrays;

//@Khvostov

/*Программа должна вывести первые 10 чисел, которые делятся на 3 или 4 без остатка,
   но цикл for выполняет итерацию от 1 до 100 (поэтому оператор break необходимо
   использовать после вывода 10 результатов). Результат должен выглядеть:
   3
   4
   …
   20*/
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();

        int[] num = new int[100];

        int count = 0;

        for (int i = 0; i < num.length; i++) {
            num[i] = random.nextInt(100);
        }

        for (int i = 1; i < 100; i++) {
            if (num[i] % 4 == 0 || num[i] % 3 == 0) {
                count++;
                System.out.print(num[i] + " ");
            }
            if (count == 10) {
                break;
            }
        }
    }
}
