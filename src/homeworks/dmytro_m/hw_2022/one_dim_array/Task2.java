package homeworks.dmytro_m.hw_2022.one_dim_array;

public class Task2 {

    public static void main(String[] args) {
        int[] m = new int[] { 10, 21, 5, 22, 9, 29, 25, 22, 11, 14, 8, 14 };
        int sum =0;
        int max = m[0];
        int min = m[0];
        for (int i = 1; i < m.length; i++) {
            sum += m[i];
            if(m[i] > max) {
                max = m[i];
            }
            if(m[i] < min) {
                min = m[i];
            }
        }
        System.out.println(min);
        System.out.println(max);
        int average = sum/m.length;
        System.out.println(average);
    }
}
//   Есть статистика за год по месяцам в виде массива:
//        int[] m = new int[] { 10, 21, 5, 22, 9, 29, 25, 22, 11, 14, 8, 14 };
//        Напишите код, который вычисляет максимальное значение из массива, минимальное значение и среднее значение.