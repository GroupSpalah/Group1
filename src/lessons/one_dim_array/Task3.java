package lessons.one_dim_array;

import java.util.Random;

/**
 * Min, max
 */
public class Task3 {
    public static void main(String[] args) {
        int[] array = new int[20];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(26) - 5;
            System.out.print(array[i] + "\t");
        }

        System.out.println();

        int max = array[0];
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
            if (array[i] < min) {
                min = array[i];
            }
        }
    }
}
