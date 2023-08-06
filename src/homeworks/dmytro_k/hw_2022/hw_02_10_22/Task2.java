package homeworks.dmytro_k.hw_2022.hw_02_10_22;

/*2) В двумерном массиве наибольший, наименьший элемент, ср. арифм. и сумму каждой строки*/

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

        int[][] array = new int[3][4];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(-2, 5);
                System.out.print(array[i][j] + "\t");
            }

            System.out.println();
        }

        for (int i = 0; i < array.length; i++) {

            int maxRow = array[i][0];
            int minRow = array[i][0];
            int sumRow = 0;

            for (int j = 0; j < array[i].length; j++) {

                if (array[i][j] > maxRow) {
                    maxRow = array[i][j];
                }

                if (array[i][j] < minRow) {
                    minRow = array[i][j];
                }

                sumRow += array[i][j];
            }

            double avg = sumRow * 1.0 / array[i].length;

            System.out.print("\nthe row " + i +
                    "\nmax is: " + maxRow +
                    "\nmin is: " + minRow +
                    "\nsum is: " + sumRow +
                    "\navg is: " + avg +
                    "\n-----------");
        }
    }
}



