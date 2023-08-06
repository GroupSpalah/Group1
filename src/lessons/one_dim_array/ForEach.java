package lessons.one_dim_array;

import java.util.Random;


public class ForEach {
    public static void main(String[] args) {
        int[] array = new int[20];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(35) + 23;
        }

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            int element = array[i];

            array[i] = i + 1;

            System.out.print(element + "\t");
        }

        for (int element : array) {
            System.out.print(element + "\t");
        }
    }
}
