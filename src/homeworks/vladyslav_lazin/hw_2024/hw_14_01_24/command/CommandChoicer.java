package homeworks.vladyslav_lazin.hw_2024.hw_14_01_24.command;

public class CommandChoicer {
    private final Command echoCommand;
    private final Command exitCommand;
    private final Command helpCommand;
    private final Command nowCommand;
    private final Command unknownCommand;

    public CommandChoicer() {
        this.echoCommand = new EchoCommand();
        this.exitCommand = new ExitCommand();
        this.helpCommand = new HelpCommand();
        this.nowCommand = new NowCommand();
        this.unknownCommand = new UnknownCommand();
    }
    public void chooseCommand(String... args) {
        switch (args[0]) {
            case "echo" -> echoCommand.execute(args);
            case "exit" -> exitCommand.execute(args);
            case "help" -> helpCommand.execute(args);
            case "now" -> nowCommand.execute(args);
            default -> unknownCommand.execute(args);
        }
    }
}
