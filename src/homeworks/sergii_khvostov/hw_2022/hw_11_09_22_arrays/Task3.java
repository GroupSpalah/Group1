package homeworks.sergii_khvostov.hw_2022.hw_11_09_22_arrays;

//@Khvostov

/*Создать массив из 20 чисел, проинициализировать его элементы случайными числами
  от 18 до 57. Вывести на консоль элементы от 9 до 15 индекса.*/

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(18, 57);
        }

        for (int i = 0; i < arr.length; i++) {
            if (i >= 9 && i < 15) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
