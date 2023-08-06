package homeworks.dmytro_k.hw_2022.hw_18_09_22_arrays_flags;

/*1) Дан массив  − 19  элементов целого типа. Найти сумму элементов, расположенных
     до первого отрицательного элемента.
     Если отрицательных элементов нет, то выдать соответствующее сообщение.
     Use flag*/

import java.util.Random;

public class Task1 {

    public static void main(String[] args) {

        int[] array = new int[19];

        Random random = new Random();

        int sum = 0;

        boolean isNegaitve = false;

  /*      for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-1, 20);
            System.out.print(array[i] + "\t");
            if (array[i] >= 0) {
                sum += array[i];
            } else if (array[i] < 0) {
                isNegaitve = true;
                break;
            }
        }*/

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(-1, 20);

            System.out.print(array[i] + "\t");

            if (array[i] < 0) {
                isNegaitve = true;
                break;
            }

            sum += array[i];


        }

        System.out.println(isNegaitve ? "\nsum: " + sum : "\nsum: " + sum
                + "\nThe array doesn't contain negative elements");
    }
}
