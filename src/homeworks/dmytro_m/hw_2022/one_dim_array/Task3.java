package homeworks.dmytro_m.hw_2022.one_dim_array;

public class Task3 {

    public static void main(String[] args) {

        int[] arr = new int[8];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 9 + 1);
            System.out.print(arr[i]);
        }

        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                arr[i] = 0;
            }
            System.out.print(arr[i]);
        }

    }
}
//    Создайте массив из 8 случайных целых чисел из отрезка [1; 10]. Выведите массив на экран в строку.
//        Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на экран на отдельной строке.
