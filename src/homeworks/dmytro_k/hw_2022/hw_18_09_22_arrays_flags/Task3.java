package homeworks.dmytro_k.hw_2022.hw_18_09_22_arrays_flags;

/* 3) Создайте массив из 8 случайных целых чисел из отрезка [1; 10]. Выведите массив на
  экран в строку.
  Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на экран на
  отдельной строке.*/

import java.util.Random;

public class Task3 {

    public static void main(String[] args) {

        int[] array = new int[8];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
            System.out.print(array[i] + "\t");
        }

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
            System.out.print(array[i] + "\t");
        }
    }
}
