package homeworks.sergii_khvostov.hw_2022.hw_02_10_22_twoDimArrays_class;

//@Khvostov

/*В двумерном массиве найти: наибольший, наименьший элемент,
  среднее арифметическое и сумму каждой строки*/

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] array = new int[4][4];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(1, 32);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        int max = 0;
        int min = array[0][0];
        int sum = 0;

        for (int[] ints : array) {
            for (int anInt : ints) {

                if (anInt > max) {
                    max = anInt;
                }
                if (anInt < min) {
                    min = anInt;
                }
                sum += anInt;
            }
        }
        double avg = (double) sum / (array.length * array[0].length);

        System.out.println("Max of array = " + max);
        System.out.println("Min of array = " + min);
        System.out.print("Avg = " + avg);

        System.out.println();

        for (int i = 0; i < array.length; i++) {
            int sumLine = 0;

            for (int j = 0; j < array[i].length; ++j) {
                sumLine += array[i][j];
            }
            System.out.println("Sum of " + i + " line = " + sumLine);
        }
    }
}
