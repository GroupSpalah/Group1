package homeworks.sergii_khvostov.hw_2022.hw_02_10_22_twoDimArrays_class;

//@Khvostov

/*Вычислить сумму элементов двумерного массива входящих в главную/обратную диагональ.*/

import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] array = new int[4][4];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {

                array[i][j] = random.nextInt(1, 32);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        int sumD1 = 0;
        int sumD2 = 0;

        int i = 0;

        while (i < array.length) {
            sumD1 += array[i][i];
            sumD2 += array[i][array.length - 1 - i];
            i++;
        }
        System.out.println("Sum diagonal 1 = " + sumD1 + "\n"
                + "Sum diagonal 2 = " + sumD2);
    }
}
