package homeworks.dmytro_k.hw_2022.hw_25_09_22;

/*3) IncrementToTop
  Create a function that returns the total number of steps to transform each
  element to the maximal element in the array. Each step consist of incrementing
  a digit by one.*/

import java.util.Random;

public class Task3TwoDim {
    public static void main(String[] args) {

        int[][] array2 = new int[4][3];
        Random randomTwoDim = new Random();
        int maxTwoDim = array2[0][0];
        int countStepsTwoDim = 0;

        for (int index1 = 0; index1 < array2.length; index1++) {
            for (int index2 = 0; index2 < array2[index1].length; index2++) {
                array2[index1][index2] = randomTwoDim.nextInt(3, 6);
                System.out.print(array2[index1][index2] + "\t");
                if (array2[index1][index2] > maxTwoDim) {
                    maxTwoDim = array2[index1][index2];
                }
            }

            System.out.println();
        }

        System.out.println("max two-dim. : " + maxTwoDim);

        for (int index1 = 0; index1 < array2.length; index1++) {
            for (int index2 = 0; index2 < array2[index1].length; index2++) {
                while (array2[index1][index2] < maxTwoDim) {
                    array2[index1][index2]++;
                    countStepsTwoDim++;
                }
            }
        }

        System.out.println("\nThe total number of steps for two-dimensional array is: " + countStepsTwoDim);
    }
}
