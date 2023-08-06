package homeworks.sergii_khvostov.hw_2022.hw_25_09_22_twoDimArrays;

//@Khvostov

/*В двумерном массиве целых чисел определить,
  сколько раз в нем встречается элемент со значением X.*/

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] arr = new int[3][5];

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; ++j) {

                arr[i][j] = random.nextInt(1, 50);
                System.out.print(arr[i][j] + " ");

                if (arr[i][j] == 21) {  //X
                    count++;
                }
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
