package homeworks.vladyslav_lazin.hw_2024.hw_14_01_24.command;

public class HelpCommand implements Command {
    @Override
    public void execute(String... args) {
        System.out.println("Help has been executed!");
    }
}
