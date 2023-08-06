package homeworks.dmytro_k.hw_2022.hw_11_09_22_loops_arrays;

/* 5) Создать два одномерных массива любой размерности. Проинициализировать массивы с помощи
циклов(for, while, do-while).
Вывести на консоль элементы с помощью тех же циклов. */

import java.util.Random;

public class Task5 {

    public static void main(String[] args) {

        int[] array1 = new int[10];
        int[] array2 = new int[25];
        Random random = new Random();

        for (int i = 0; i < array1.length; i++) {
            array1[i] = random.nextInt(1000, 2000);
            System.out.print(array1[i] + "\t");
        }

        System.out.println();

        int i2 = 0;

        while (i2 < array1.length) {
            array1[i2] = random.nextInt(100, 200);
            System.out.print(array1[i2] + "\t");
            i2++;
        }

        System.out.println();

        int i3 = 0;

        do {
            array2[i3] = random.nextInt(20, 80);
            System.out.print(array2[i3] + "\t");
            i3++;
        } while (i3 < array2.length);
    }
}

