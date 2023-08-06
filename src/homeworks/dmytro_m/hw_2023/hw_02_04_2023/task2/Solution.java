package homeworks.dmytro_m.hw_2023.hw_02_04_2023.task2;

import homeworks.dmytro_k.hw_2023.hw_02_04_23.task2.Array;
import homeworks.dmytro_k.hw_2023.hw_02_04_23.task2.ArrayUtil;

public class Solution {
    public static void main(String[] args) {

        //Print to display:
        Integer[] set1 = new Integer[]{1, 2, 4, 5};
        double averageValue1 = ArrayUtil.averageValue(set1);
        System.out.println(averageValue1);

        //Print to display:
        Array<Integer> set3 = new Array<>(new Integer[]{1, 2, 4, 5});
        double averageValue3 = ArrayUtil.averageValue(set3);
        System.out.println(averageValue3);

        //Print to display:
        Array<Double> set2 = new Array<>(new Double[]{1.0, 3.0, 5.0});
        double averageValue2 = ArrayUtil.averageValue(set2);
        System.out.println(averageValue2);
    }
}
//* Предположим, у нас есть следующий универсальный класс:
//        * <р>
// * В классе ArrayUtil пишем static
// * метод с именем "averageValue(...)", который
//         * принимает на вход объект типа Array,
//         * и возвращает среднее значение его
//         * элементы Данный метод должен
//         * возвращает значение типа double и принимает
//         * любой массив, элементы которого расширяются
//         * Тип номера
//         * <р>
// * Примеры использования:
//         * <р>
// * // Печать для отображения:
//         * Array <Integer> set1 new Array<>(new Integer[] {1, 2, 4, 5});
//        * двойное среднее значение1 ArrayUti1.averageValue(set);
//        * System.out.println(среднее значение1).
//        * <р>
// * // Печать для отображения:
//         * Массив <Double> set2 new Array<> (new Double[] {1.0, 3.0, 5.0});
//        * двойное среднее значение2 = ArrayUtil.averageValue (set2);
//        * System.out.println(averageValue2);
//        * <р>
// * выбирайте правильную передачу всех остатков не используйте в коде методы print и println