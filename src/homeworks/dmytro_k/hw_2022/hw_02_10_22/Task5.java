package homeworks.dmytro_k.hw_2022.hw_02_10_22;

/* 5) Write a program, which creates square matrix like those in the figure below and prints them formatted
 to the console.
 The size of the matrix is 4 x 4:

 1 5 9  13
 2 6 10 14
 3 7 11 15
 4 8 12 16
 //i0j0 i0j1 i0j2 i0j3
 //i1j0 i1j1 i1j2 i1j3
 //i2j0 i2j1 i2j2 i2j3
 //i3j0 i3j1 i3j2 i3j3*/

public class Task5 {
    public static void main(String[] args) {

        int matrixOrder = 4;
        int[][] array = new int[matrixOrder][matrixOrder];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = i + j * array.length + 1;
                System.out.print(array[i][j] + "\t");
            }

            System.out.println();
        }
    }
}
