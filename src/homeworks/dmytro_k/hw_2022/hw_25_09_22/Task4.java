package homeworks.dmytro_k.hw_2022.hw_25_09_22;

/* 4) В двумерном массиве случайных чисел от 10 до 99 найти количество всех
   двухзначных чисел, у которых сумма цифр кратная 2.*/

import java.util.Random;

public class Task4 {
    public static void main(String[] args) {

        int[][] array = new int[5][3];
        Random random = new Random();
        int countNumbers = 0;

        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                array[i][i1] = random.nextInt(10, 100);
                System.out.print(array[i][i1] + "\t");
                if (((array[i][i1] / 10) + (array[i][i1] % 10)) % 2 == 0) {
                    countNumbers++;
                }
            }

            System.out.println();
        }

        System.out.println("\nNumber of numbers whose sum of digits is a multiple of 2." +
                "\nResult: " + countNumbers);
    }
}
