package lessons.one_dim_array;

import java.util.Random;

public class OneDimArray {
    public static void main(String[] args) {
//        datatype[] name = new datatype[size];

        int[] array = new int[5];
        int[] array1 = {4, 8, 7, 9};
        int[] array2 = new int[]{4, 8, 7, 9};

        /*array[0] = 10;
        array[1] = 4;
        array[2] = 3;
        array[3] = 9;
        array[4] = 7;*/

//        System.out.println(array[2]);

        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
            System.out.print(array[i] + "\t");
        }
    }
}
