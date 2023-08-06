package homeworks.dmytro_m.hw_2022.home_work_02_10_2022;

import java.util.Random;

public class Task5 {
    public static void main(String[] args) {
        Random r = new Random();
        int[][] arr = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = r.nextInt(1, 6);
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = i + 1 + j * 4;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//    Напишите программу, которая создает квадратную матрицу, как на рисунке ниже, и печатает ее в отформатированном виде.
// в консоль.
//Размер матрицы 4 х 4:
///Размер матрицы 4 х 4:
//
//        1 5 9  13
//        2 6 10 14
//        3 7 11 15
//        4 8 12 16
//
//        for (int i = 0; i < 4; i++) {
//        for (int j = 0; j < 4; j++) {
//        array[i][j] = i + 1 + j * 4 ;
//        }
//        }
