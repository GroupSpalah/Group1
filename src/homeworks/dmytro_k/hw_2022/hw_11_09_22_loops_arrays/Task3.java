package homeworks.dmytro_k.hw_2022.hw_11_09_22_loops_arrays;

/*  3) Write a program to produce the sum of 1, 2, 3, ..., to an upper bound - 70.
   Also compute and display the average.
   The output shall look like:
   The Sum is: 100
   The Avg is: 10 */

public class Task3 {

    public static void main(String[] args) {

        int sum = 0;
        int count = 0;

        for (int i = 1; i <= 100; i++) {
            sum += i;
            count++;
        }

        double avg = sum * 1.0 / count;

        System.out.println("The Sum is: " + sum +
                "\nThe Avg is: " + avg);
    }
}

