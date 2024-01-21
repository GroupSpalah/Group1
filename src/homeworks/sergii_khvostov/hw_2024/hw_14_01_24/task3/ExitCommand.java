package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task3;

public class ExitCommand implements Command {
    @Override
    public void execute(String... args) {
        System.out.println("Goodbye!");
        System.exit(0);
    }
}
