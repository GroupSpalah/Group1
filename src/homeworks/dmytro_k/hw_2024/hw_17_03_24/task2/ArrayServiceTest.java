package homeworks.dmytro_k.hw_2024.hw_17_03_24.task2;

public class ArrayServiceTest {
    public static void main(String[] args) {

        int[] array = new int[10];
        ArrayService arrayService = new ArrayService(array);
        arrayService.startThreads();
    }
}
