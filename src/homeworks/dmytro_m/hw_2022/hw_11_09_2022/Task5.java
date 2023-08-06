package homeworks.dmytro_m.hw_2022.hw_11_09_2022;


public class Task5 {
    public static void main(String[] args) {
//        Создать два одномерных массива любой размерности. Проинициализировать массивы с помощи циклов(for, while, do-while).
//        Вывести на консоль элементы с помощью тех же циклов.
        double[] arr1 = new double[5];

        int[] arr2 = new int[10];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 20 + Math.random() * 40;
            System.out.print(arr1[i] + " ");
        }

        System.out.println();

        int counter = 0;

        while (counter < arr2.length) {
            arr2[counter] = (int) (10 + Math.random() * 20);
            System.out.print(arr2[counter] + " ");
            counter++;
        }
    }
}
