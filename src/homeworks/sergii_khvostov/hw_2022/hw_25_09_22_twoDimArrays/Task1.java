package homeworks.sergii_khvostov.hw_2022.hw_25_09_22_twoDimArrays;

//@Khvostov

/*В одномерном массиве целых чисел с количеством элементов 19.
  Определить максимальное число и заменить им все четные по значению элементы.*/

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[19];

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {

            arr[i] = random.nextInt(1, 30);

            if (arr[i] > max) {
                max = arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                arr[i] = max;
            }
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("MAX: " + max);
    }
}
