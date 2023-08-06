package homeworks.dmytro_k.hw_2022.hw_25_09_22;

/* 2) В двумерном массиве целых чисел определить, сколько раз в нем встречается
   элемент со значением X.*/

import java.util.Random;

public class Task2 {
    public static void main(String[] args) {

        int[][] array = new int[8][8];

        Random random = new Random();

        int countReiterations = 0;

        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                array[i][i1] = random.nextInt(0, 2);
                System.out.print(array[i][i1] + "\t");
                if (array[i][i1] == 1) {
                    countReiterations++;
                }
            }

            System.out.println();
        }

        System.out.println("\nelement with value 1 is repeated: "
                + countReiterations + " times");
    }
}



