package lessons.two_dim_array;

import java.util.Random;

public class TwoDimArray {
    public static void main(String[] args) {
        int[][] arr = {
                //0 1  2
                {4, 7, 9},//0
                {8},//1
                {2, 1}//2
        };

//        arr[0][1]

        int[][] array = new int[4][5];

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(20);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
