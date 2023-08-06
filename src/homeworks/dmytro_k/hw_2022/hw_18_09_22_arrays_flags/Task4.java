package homeworks.dmytro_k.hw_2022.hw_18_09_22_arrays_flags;

/* 4) Создать массив, состоящий из 20 элементов целого типа. Определить
   каких элементов больше четных или нечетных по значению.*/

import java.util.Random;

public class Task4 {

    public static void main(String[] args) {

        int[] array = new int[20];
        Random random = new Random();
        int countEven = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 3);
            System.out.print(array[i] + "\t");
            if (array[i] % 2 == 0) {
                countEven++;
            }
        }

        int result = array.length / 2;

        if (result < countEven) {
            System.out.println("\nMore even numbers");
        } else if (result > countEven) {
            System.out.println("\nMore odd numbers");
        } else {
            System.out.println("\nEven and odd numbers equally");
        }
    }
}
