package homeworks.dmytro_k.hw_2022.hw_02_10_22;

/*4) Вычислить сумму элементов двумерного массива входящих в главную/обратную диагональ.

            //i0j0 i0j1 i0j2 i0j3
            //i1j0 i1j1 i1j2 i1j3
            //i2j0 i2j1 i2j2 i2j3
            //i3j0 i3j1 i3j2 i3j3*/

import java.util.Random;

public class Task4 {
    public static void main(String[] args) {

        int matrixOrder = 5;
        int[][] array = new int[matrixOrder][matrixOrder];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(1, 10);
                System.out.print(array[i][j] + "\t");
            }

            System.out.println();
        }

        System.out.println("\nthe main diagonal is: ");

        int sumMainDiag = 0;

        /*for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    System.out.print(array[i][j] + "\t");
                    sumMainDiag += array[i][j];
                }
            }
        }*/
            // вопрос!!!
        for (int i = 0; i < array.length; i++) {
            sumMainDiag += array[i][i];
            System.out.println(array[i][i]);
        }

        System.out.println("\nsum of the main diagonal is: " + sumMainDiag);

        System.out.println("\nreciprocal diagonal is: ");

        int sumReciprocalDiag = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                /*if (i + j == array.length - 1)
                    if (array.length - i - j - 1 == 0) //alternatives
                        if (j == array.length - 1 - i)*/
                if (i + j + 1 == array.length) {
                    System.out.print(array[i][j] + "\t");
                    sumReciprocalDiag += array[i][j];
                }
            }
        }

        System.out.println("\nreciprocal diagonal sum is: " + sumReciprocalDiag);
    }
}
