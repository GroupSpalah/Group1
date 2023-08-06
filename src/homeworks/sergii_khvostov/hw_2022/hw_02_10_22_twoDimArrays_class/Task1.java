package homeworks.sergii_khvostov.hw_2022.hw_02_10_22_twoDimArrays_class;

//@Khvostov

/*Дан двумерный массив целых чисел. Вычислить сумму элементов первой
  и последней строк данной матрицы.*/

import java.util.Random;

public class Task1 {
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

        int sumFirstLine = 0;
        int sumLastLine = 0;

        for (int i = 0; i < array.length; ++i) {
            for (int j = 0; j < array[i].length; ++j) {

                if (i == 0) {
                    sumFirstLine += array[i][j];
                }
                if (array.length - 1 == i) {
                    sumLastLine += array[i][j];
                }
            }
        }
        System.out.println("Sum first line: " + sumFirstLine);
        System.out.println("Sum last line: " + sumLastLine);
    }
}
