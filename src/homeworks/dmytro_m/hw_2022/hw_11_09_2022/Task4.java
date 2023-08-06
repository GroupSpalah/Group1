package homeworks.dmytro_m.hw_2022.hw_11_09_2022;


public class Task4 {
    public static void main(String[] args) {
//        Создать массив из 20 чисел, проинициализировать его элементы случайными числами от 18 до 57.
//        Вывести на консоль элементы от 9 до 15 индекса.
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (18 + Math.random() * 57);
            if (i >= 9 && i <= 15) {
                System.out.println(arr[i]);
            }
        }

    }
}
