package homeworks.sergii_khvostov.hw_2022.hw_11_09_22_arrays;

//Khvostov

/*Создать два одномерных массива любой размерности. Проинициализировать массивы при помощи
  циклов(for, while, do-while). Вывести на консоль элементы с помощью тех же циклов.*/

public class Task4 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        int[] arr2 = new int[10];

        //for
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = i;
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        System.out.println("*************************");

        //while
        int k = 0;
        while (k < arr1.length) {
            System.out.print(arr1[k] + " ");
            k++;
        }
        System.out.println();

        int j = 0;
        while (j < arr2.length) {
            System.out.print(arr2[j] + " ");
            j++;
        }
        System.out.println();
        System.out.println("**************************");

        // do-while
        if (arr1.length > 0) {
            int t = 0;
            do {
                System.out.print(arr1[t] + " ");
                t++;
            }
            while (t < arr1.length);
        }
        System.out.println();

        if (arr2.length > 0) {
            int r = 0;
            do {
                System.out.print(arr2[r] + " ");
                r++;
            }
            while (r < arr2.length);
        }
    }
}
