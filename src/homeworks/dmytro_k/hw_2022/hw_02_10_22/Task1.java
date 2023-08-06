package homeworks.dmytro_k.hw_2022.hw_02_10_22;

/* 1) Дан двумерный массив целых чисел. Вычислить сумму элементов первой и последней
строк данной матрицы.*/

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        int[][] array = new int[4][4];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(1, 5);
                System.out.print(array[i][j] + "\t");
            }

            System.out.println();
        }

        int sumFirstLine = 0;

        int sumLastLine = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == 0) {
                    sumFirstLine += array[i][j];
                }

                if (i == array.length - 1) {
                    sumLastLine += array[i][j];
                }
            }
        }

        /*for (int i = 0; i < array[0].length; i++) {

            sumFirstLine += array[0][i];

            sumLastLine += array[array.length - 1][i];

        }*/

        System.out.println("Sum first line: " + sumFirstLine);
        System.out.println("Sum last line: " + sumLastLine);
    }
}
