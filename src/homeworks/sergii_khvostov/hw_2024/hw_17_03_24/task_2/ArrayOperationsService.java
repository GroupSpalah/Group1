package homeworks.sergii_khvostov.hw_2024.hw_17_03_24.task_2;

public class ArrayOperationsService {
    public static void main(String[] args) {
        ArrayOperations arrayOperations = new ArrayOperations();
        Thread thread = new Thread(arrayOperations);
        thread.start();
    }
}
