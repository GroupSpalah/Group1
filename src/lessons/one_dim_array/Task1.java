package lessons.one_dim_array;

import java.util.Random;

/**
 * Создать массив из 20 чисел, проинициализировать его элементы случайными числами от 23 до 57.
 * Вывести на консоль элементы если индекс элемента четный и элемент больше 30.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[20];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(35) + 23;
            System.out.print(array[i] + "\t");
        }

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0 && array[i] > 30) {
                System.out.print(array[i] + "\t");
            }
        }
    }
}
