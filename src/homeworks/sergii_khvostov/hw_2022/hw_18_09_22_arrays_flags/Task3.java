package homeworks.sergii_khvostov.hw_2022.hw_18_09_22_arrays_flags;

//@Khvostov

/*Создайте массив из 8 случайных целых чисел из отрезка [1; 10].
  Выведите массив на экран в строку. Замените каждый элемент с нечётным индексом на ноль.
  Снова выведете массив на экран на отдельной строке.*/

public class Task3 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 8, 4, 6, 3, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 != 0) {
                arr[i] = 0;
            }
            System.out.print(arr[i] + " ");
        }
    }
}
