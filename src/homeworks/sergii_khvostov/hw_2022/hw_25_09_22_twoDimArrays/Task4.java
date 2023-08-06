package homeworks.sergii_khvostov.hw_2022.hw_25_09_22_twoDimArrays;

//@Khvostov

/*В двумерном массиве случайных чисел от 10 до 99.
  Найти количество всех двухзначных чисел, у которых сумма цифр кратная 2.*/

import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] arr = new int[5][5];

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                arr[i][j] = random.nextInt(10, 99);
                System.out.print(arr[i][j] + " ");

                if (arr[i][j] / 10 + arr[i][j] % 10 == 2) {
                    count++;
                }
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
