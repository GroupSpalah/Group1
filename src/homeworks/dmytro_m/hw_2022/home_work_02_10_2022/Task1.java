package homeworks.dmytro_m.hw_2022.home_work_02_10_2022;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] array = new int[3][3];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = r.nextInt(1, 21);
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        int firstLine = 0;
        for (int i = 0; i < array[0].length; i++) {
            firstLine += array[0][i];
        }

        int lastLine = 0;
        for (int i = 0; i < array[array.length - 1].length; i++) {
            lastLine += array[array.length - 1][i];
        }
        System.out.println("The sum of the elements of the first row of the matrix " + firstLine);
        System.out.println("The sum of the elements of the last row of the matrix " + lastLine);
    }
}
//    Дан двумерный массив целых чисел.
//        Вычислить сумму элементов первой и последней строк данной матрицы.