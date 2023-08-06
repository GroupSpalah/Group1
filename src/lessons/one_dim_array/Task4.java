package lessons.one_dim_array;

import java.util.Random;

/**
 * Дан массив чисел. В массиве числа в диапазоне от -15 до 15.
 * Выяснить, имеются ли в данном массиве два идущих подряд положительных элемента.
 * Подсчитать количество таких пар.
 */
public class Task4 {
    public static void main(String[] args) {
        int[] array = new int[20];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(31) - 15;
            System.out.print(array[i] + "\t");
        }

        int countPairs = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > 0 && array[i + 1] > 0) {
                ++countPairs;
            }
        }

        System.out.println(countPairs);
    }
}
