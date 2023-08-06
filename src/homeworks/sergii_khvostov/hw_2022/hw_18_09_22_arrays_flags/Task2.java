package homeworks.sergii_khvostov.hw_2022.hw_18_09_22_arrays_flags;

//Khvostov

/*There are statistics for the year by months as an array:
  int[] m = new int[] { 10, 21, 5, 22, 9, 29, 25, 22, 11, 14, 8, 14 };
  Write code which calculates the maximum value from the array,
  the minimum value and the average.*/

public class Task2 {
    public static void main(String[] args) {
        int[] m = new int[]{10, 21, 5, 22, 9, 29, 25, 22, 11, 14, 8, 14};

        //MAX
        int max = m[0];
        int min = m[0];
        int sum = 0;

        for (int i = 0; i < m.length; i++) {
            if (m[i] > max) {
                max = m[i];
            }

            if (m[i] < min) {
                min = m[i];
            }

            sum += m[i];
        }
        System.out.println("Min: " + min);

        System.out.println("Max: " + max);

        double avg = (double) sum / m.length;
        System.out.println("Avg: " + avg);
    }
}
