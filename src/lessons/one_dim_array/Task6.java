package lessons.one_dim_array;

/**
 Сложить два массива произвольной длины каждый.
 */
public class Task6 {
    public static void main(String[] args) {
        int[] array1 = {4, 7, 8, 2, 1, 7, 9};
        int[] array2 = {9, 2, 5, 6, 1};
        int[] array3 = new int[array1.length + array2.length];//12

        for (int i = 0; i < array1.length; i++) {
            array3[i] = array1[i];//{4, 7, 8, 2, 1, 7, 9, 0, 0, 0, 0, 0}
        }

        int a, b = 10;

        for (int i = array1.length, j = 0; i < array3.length; i++, ++j) {
            array3[i] = array2[j];
        }

    }
}
