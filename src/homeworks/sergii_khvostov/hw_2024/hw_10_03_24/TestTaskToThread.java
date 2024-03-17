package homeworks.sergii_khvostov.hw_2024.hw_10_03_24;

public class TestTaskToThread {
    public static void main(String[] args) throws InterruptedException {
        TaskToThread taskToThread = new TaskToThread("and");
        taskToThread.execute();
    }
}
