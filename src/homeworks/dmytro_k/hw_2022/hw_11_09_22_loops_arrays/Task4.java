package homeworks.dmytro_k.hw_2022.hw_11_09_22_loops_arrays;

/*  4) Создать массив из 20 чисел, проинициализировать его элементы случайными числами
от 18 до 57.
Вывести на консоль элементы от 9 до 15 индекса. */

import java.util.Random;

public class Task4 {

    public static void main(String[] args) {

        int[] array = new int[20];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(18, 58);
            if (i >= 9 && i <= 15) {
                System.out.print(array[i] + "\t");
            }
        }

        for (int i = 9; i < 15; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
