package homeworks.dmytro_k.hw_2023.hw_02_04_23.task2;

public class ArrayUtilService {
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
