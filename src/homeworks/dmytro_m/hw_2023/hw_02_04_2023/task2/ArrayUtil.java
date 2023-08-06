package homeworks.dmytro_m.hw_2023.hw_02_04_2023.task2;

public class ArrayUtil {
    public static <T extends Number> double averageValue(T[] arr) {

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i].doubleValue();
        }
        return sum/ arr.length;
    }
}
