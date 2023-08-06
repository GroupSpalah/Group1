package homeworks.dmytro_m.hw_2022.hw_18_09_2022;

import java.util.Random;

public class Task1 {
    public static void main(String[] args) {

        int[] arr = new int[19];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1, 20);
            System.out.print(arr[i]+ " ");
        }

        int sum = 0;
        boolean negative = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                negative = true;
                break;
            }
            sum += arr[i];
        }

        System.out.println();

        if(!negative){
            System.out.println("отрицательных элементов  в массиве нет");
        }

        System.out.println("сумма элементов расположенных до первого отрицательного элемента " + sum);

    }
}
//        Дан массив  − 19  элементов целого типа. Найти сумму элементов,
//                расположенных до первого отрицательного элемента.
//        Если отрицательных
//        элементов нет, то выдать соответствующее сообщение. Use flag