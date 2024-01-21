package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task3;

public class EchoCommand implements Command {
    @Override
    public void execute(String... args) {
        System.out.println(String.join(" ", args));
    }
}
