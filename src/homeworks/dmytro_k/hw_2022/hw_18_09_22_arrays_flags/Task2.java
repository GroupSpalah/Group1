package homeworks.dmytro_k.hw_2022.hw_18_09_22_arrays_flags;

/*
2) There are statistics for the year by months as an array:
   int[] m = new int[] { 10, 21, 5, 22, 9, 29, 25, 22, 11, 14, 8, 14 };
   Write code which calculates the maximum value from the array, the minimum
   value and the average.
*/

public class Task2 {

    public static void main(String[] args) {

        int[] months = new int[]{10, 21, 5, 22, 9, 29, 25, 22, 11, 14, 8, 14};
        int max = months[0];
        int min = months[0];
        int sum = 0;

        for (int month : months) {
            sum += month;
            if (month > max) {
                max = month;
            }
            if (month < min) {
                min = month;
            }
        }

        double avg = sum * 1.0 / months.length;

        System.out.println("max: " + max +
                "\nmin: " + min +
                "\nThe average is: " + avg);
    }
}
