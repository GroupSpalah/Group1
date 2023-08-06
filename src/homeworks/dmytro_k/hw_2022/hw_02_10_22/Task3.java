package homeworks.dmytro_k.hw_2022.hw_02_10_22;

/*3) В двумерном массиве Необходимо найти и вывести наибольший, наименьший элемент,
 сумму всех элементов каждого столбца.*/

import java.util.Random;

public class Task3 {
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

        int countColumn = 0;

        for (int i = 0; i < array[0].length; i++) {

            int maxColumn = array[0][i], minColumn = array[0][i], sumColumn = 0;

            for (int j = 0; j < array.length; j++) {

                if (array[j][i] > maxColumn) {
                    maxColumn = array[j][i];
                }
                if (array[j][i] < minColumn) {
                    minColumn = array[j][i];
                }

                sumColumn += array[j][i];
            }

            countColumn++;

            System.out.print("\nthe column " + countColumn +
                    "\nmax is: " + maxColumn +
                    "\nmin is: " + minColumn +
                    "\nsum is: " + sumColumn +
                    "\n-----------");
        }
    }
}
