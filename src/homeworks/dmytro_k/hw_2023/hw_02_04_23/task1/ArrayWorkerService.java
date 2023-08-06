package homeworks.dmytro_k.hw_2023.hw_02_04_23.task1;

public class ArrayWorkerService {
    public static void main(String[] args) {

        Integer[] arrIn1 = {1, 3, 5, 7, 3, 9, 0, 4};
        Double[] arrIn2 = {1.02356, 3.466, 5.656, 7.0, 3.0, 9.0, 0.0, 4.99999998};

        int count = ArrayWorker.calcNum(arrIn1, 5);

        System.out.println(count);
    }
}
