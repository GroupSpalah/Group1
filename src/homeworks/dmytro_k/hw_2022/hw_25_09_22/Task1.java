package homeworks.dmytro_k.hw_2022.hw_25_09_22;

/* 1) В одномерном массиве целых чисел с количеством элементов 19 определить
   максимальное число и заменить им все четные по значению элементы.*/

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        int[] array = new int[19];

        Random random = new Random();

        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-1, 0);
            System.out.print(array[i] + "\t");
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("\nmax = " + max);

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                array[i] = max;
            }

            System.out.print(array[i] + "\t");
        }
    }
}
