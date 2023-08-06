package homeworks.dmytro_m.hw_2022.home_work_25_09_2022;

import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[19];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1,21);
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        System.out.println(maxValue);


        for (int i = 0; i < arr.length; i++) {
            if(arr[i] % 2 == 0) {
                arr[i] = maxValue;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
//    В одномерном массиве целых чисел с количеством элементов 19 определить максимальное число и
//        заменить им все четные по значению элементы.