package lessons.two_dim_array;

import java.util.Random;

public class WorkWithColumn {
    public static void main(String[] args) {

        int[][] array = new int[4][5];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(20);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        for (int i = 0; i < array[0].length; i++) {

            int max = array[i][0];

            for (int[] ints : array) {
                if (ints[i] > max) {
                    max = ints[i];
                }
            }

            System.out.println("Max = " + max);
        }
    }
}
