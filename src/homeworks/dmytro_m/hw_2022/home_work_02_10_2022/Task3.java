package homeworks.dmytro_m.hw_2022.home_work_02_10_2022;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {

        Random r = new Random();
        int[][] array = new int[3][3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = r.nextInt(1, 20);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int largestElement = array[0][0];
        int smallestElement = array[0][0];

        for (int[] arr : array) {

            for (int j : arr) {
                if (largestElement < j) {
                    largestElement = j;
                }

                if (smallestElement > j) {
                    smallestElement = j;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < array[0].length; i++) {
            for (int j = 0; j < array.length; j++) {
                sum += array[j][i];
            }
            System.out.println("sum of column elements " + i + " equals " + sum);
            sum = 0;
        }

        System.out.println("Largest element in array " + largestElement);
        System.out.println("Smallest Element in array " + smallestElement);
    }
}
//    В двумерном массиве Необходимо найти и вывести наибольший, наименьший элемент,
//        сумму всех элементов каждого столбца.