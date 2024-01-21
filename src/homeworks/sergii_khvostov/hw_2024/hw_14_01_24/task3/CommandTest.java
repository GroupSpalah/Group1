package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task3;

public class CommandTest {
    public static void main(String[] args) {
        CommandExecutor executor= new CommandExecutor();

        executor.executeCommand("help");
        executor.executeCommand("echo","Hello World");
        executor.executeCommand("now");
        executor.executeCommand("exit");
    }
}
