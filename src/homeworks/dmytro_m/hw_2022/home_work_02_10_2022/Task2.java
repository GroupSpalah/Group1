package homeworks.dmytro_m.hw_2022.home_work_02_10_2022;

import java.util.Random;

public class Task2 {
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

        /*
        * 7 8 9
        * 4 5 6
        * 2 1 3
        * */

        int largestElement = array[0][0];
        int smallestElement = array[0][0];
        int sumElement = 0;
        int count = 0;
        int sumLine = 0;
        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j < array[i].length; j++) {
                sumLine += array[i][j];
                sumElement += array[i][j];
                count++;

                if (largestElement < array[i][j]) {
                    largestElement = array[i][j];
                }

                if (smallestElement > array[i][j]) {
                    smallestElement = array[i][j];
                }

                if(j == array[i].length -1) {
                    System.out.println("Summa elements " + i + " line " + sumLine);
                    sumLine = 0;
                }
            }
        }
        int average = sumElement/count;

        System.out.println( "Largest element in array " + largestElement);
        System.out.println("Smallest Element in array " + smallestElement);
        System.out.println("Average in array " +average);
    }
}
//    В двумерном массиве наибольший, наименьший элемент, ср. арифм. и сумму каждой строки