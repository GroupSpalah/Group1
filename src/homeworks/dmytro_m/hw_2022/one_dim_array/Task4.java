package homeworks.dmytro_m.hw_2022.one_dim_array;

public class Task4 {

    public static void main(String[] args) {

        int honest = 0;
        int odd = 0;
        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 9 + 1);
            if (arr[i] % 2 == 0) {
                honest++;
            } else {
                odd++;
            }
            System.out.println(arr[i]);
        }

        System.out.println(honest);
        System.out.println(odd);
    }
}
//    Создать массив, состоящий из 20 элементов целого типа. Определить
//        каких элементов больше четных или нечетных по значению.