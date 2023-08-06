package homeworks.dmytro_m.hw_2022.home_work_25_09_2022;

import java.util.Random;

public class Task4 {

    public static void main(String[] args) {

        Random random = new Random();
        int[][] arr = new int[3][6];
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(10,100) ;
                System.out.print(arr[i][j] + " ");

                int first = arr[i][j] / 10;
                int second = arr[i][j] % 10;
                if ((first + second) % 2 == 0) {
                    count++;
                }
            }
            System.out.println();
        }

        System.out.println(count);
    }
}
//    В двумерном массиве случайных чисел от 10 до 99 найти количество всех двухзначных чисел,
//        у которых сумма цифр кратная 2.
