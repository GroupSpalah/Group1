package homeworks.dmytro_m.hw_2022.home_work_02_10_2022;

import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] arr = new int[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = r.nextInt(1, 6);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        int sumSecondDiag = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0; j < arr[i].length; ++j) {

                if (i == arr.length - 1 - j) {
                    sumSecondDiag += arr[i][j];
                }

                if (j == i) {
                    sum += arr[i][j];
                }
            }
        }

        System.out.println(sumSecondDiag);
        System.out.println(sum);
    }
}
//4) Вычислить сумму элементов двумерного массива входящих в главную/обратную диагональ.
