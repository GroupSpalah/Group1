package homeworks.sergii_khvostov.hw_2024.hw_14_01_24.task3;

public class CommandExecutor {
    private Command helpCommand;
    private Command echoCommand;
    private Command nowCommand;
    private Command exitCommand;

    public CommandExecutor() {
        helpCommand = new HelpCommand();
        echoCommand = new EchoCommand();
        nowCommand = new NowCommand();
        exitCommand = new ExitCommand();
    }

    public void executeCommand(String command, String... args) {
        switch (command) {
            case "help":
                helpCommand.execute(args);
                break;
            case "echo":
                echoCommand.execute(args);
                break;
            case "now":
                nowCommand.execute(args);
                break;
            case "exit":
                exitCommand.execute(args);
                break;
            default:
                System.out.println("Error");
        }
    }
}
