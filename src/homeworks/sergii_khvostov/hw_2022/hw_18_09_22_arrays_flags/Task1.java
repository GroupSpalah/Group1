package homeworks.sergii_khvostov.hw_2022.hw_18_09_22_arrays_flags;

//@Khvostov

/*Дан массив − 19 элементов целого типа. Найти сумму элементов,
 расположенных до первого отрицательного элемента.
Если отрицательных элементов нет, то выдать соответствующее сообщение.Use flag.*/

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[19];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }

        int sum = 0;
        boolean negative = false;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if (array[i] < 0) {
                negative = true;
                break;
            }
        }
        System.out.print("Sum of elements: " + sum);
        System.out.println();

        if (!negative) {
            System.out.println("The array does not contain negative numbers.");
        }
    }
}
