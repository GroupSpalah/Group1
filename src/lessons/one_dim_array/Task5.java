package lessons.one_dim_array;

/**
 * Даны два массива действительных чисел по 6 элементов в каждом.
 * Заменить нулями те элементы первого массива, которые есть во втором.
 */
public class Task5 {
    public static void main(String[] args) {
        int[] array1 = {4, 7, 8, 2, 1};
        int[] array2 = {0, 2, 5, 6, 1};

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    array1[i] = 0;
                }
            }
        }

    }
}
