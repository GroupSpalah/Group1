package homeworks.dmytro_k.hw_2022.hw_25_09_22;

/*3) IncrementToTop
  Create a function that returns the total number of steps to transform each
  element to the maximal element in the array. Each step consist of incrementing
  a digit by one.*/

import java.util.Arrays;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {

        //v 1.0

        int[] array = new int[3];
        Random random = new Random();
        int max = array[0];
        int countSteps = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(3, 6);
            System.out.print(array[i] + "\t");
            if (array[i] > max) {
                max = array[i];
            }
        }

        for (int i = 0; i < array.length; i++) {
            while (array[i] < max) {
                array[i]++;
                countSteps++;
            }
        }

        System.out.println("\nThe total number of steps is: " + countSteps);

        //v 2.0 (Bonus)

        //int[] array1 = new int[] {3,10,3};

        //v 2.1 (Bonus)

        int[] array1 = new Random().ints(3, 2, 6).toArray();

        Arrays.sort(array1);
        int maxValue = array1[array1.length - 1];
        int countSteps1 = 0;

        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
            while (array1[i] < maxValue) {
                array1[i]++;
                countSteps1++;
            }
        }

        System.out.println("\nThe total number of steps is: " + countSteps1);
    }
}
