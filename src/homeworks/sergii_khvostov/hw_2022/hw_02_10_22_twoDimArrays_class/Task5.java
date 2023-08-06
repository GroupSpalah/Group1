package homeworks.sergii_khvostov.hw_2022.hw_02_10_22_twoDimArrays_class;

//@Khvostov

/*Write a program, which creates square matrix like those in the figure below
 and prints them formatted to the console.
 The size of the matrix is 4 x 4:
 The size of the matrix is 4 x 4:
 1 5 9  13
 2 6 10 14
 3 7 11 15
 4 8 12 16*/

public class Task5 {
    public static void main(String[] args) {
        int[][] array = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                array[i][j] = i + 1 + j * 4 ;
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
