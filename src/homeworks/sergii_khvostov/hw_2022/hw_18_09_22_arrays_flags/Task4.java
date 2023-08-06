package homeworks.sergii_khvostov.hw_2022.hw_18_09_22_arrays_flags;

//@Khvostov

/*Создать массив, состоящий из 20 элементов целого типа. Определить
      каких элементов больше чётных или нечетных по значению.*/

public class Task4 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 10, 20, 15, 6, 9, 14, 18, 25, 32, 11, 7, 29, 13, 12,
                22, 35, 4, 27};

        int even = 0; // Чётные
        int odd = 0; // Нечётные

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }

        }

        if (even > odd) {
            System.out.println("More even elements");
        } else {
            System.out.println("More odd elements");
        }
    }
}
