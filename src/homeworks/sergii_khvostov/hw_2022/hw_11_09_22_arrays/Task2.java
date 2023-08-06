package homeworks.sergii_khvostov.hw_2022.hw_11_09_22_arrays;

//@Khvostov

/*Write a program to produce the sum of 1, 2, 3, ..., to an upper bound - n.
   Also compute and display the average.
   The output shall look like:
   The Sum is: 100
   The Avg is: 10*/

public class Task2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int sum = 0;
        int avg = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("The Sum is: " + sum);

        for (int i = 0; i < arr.length; i++) {
            avg = sum / arr.length;
        }
        System.out.println("The Avg is: " + avg);

    }
}
