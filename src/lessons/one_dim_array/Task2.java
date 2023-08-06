package lessons.one_dim_array;

import java.util.Random;

/**
 * Создать массив из 10 чисел, проинициализировать его элементы случайными числами от -5 до 20.
 * Если в массиве есть отрицательные элементы тогда вывести на консоль сообщение об этом.
 */
public class Task2 {
    public static void main(String[] args) {
        int[] array = new int[20];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(26) - 5;
            System.out.print(array[i] + "\t");
        }

        System.out.println();

     /*   for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                System.out.print("There are negative values");
                break;
            }
        }*/

        boolean isNegaitve = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                isNegaitve = true;
                break;
            }
        }

        /*if (isNegaitve) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }*/

        System.out.println(isNegaitve ? "Yes" : "No");
    }
}
