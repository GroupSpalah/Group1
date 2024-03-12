package homeworks.vladyslav_lazin.hw_2024.hw_14_01_24.command;

import java.util.Scanner;

public class CommandConsole {
    public static void main(String... args) {
        CommandChoicer commandChoicer = new CommandChoicer();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(">>>");
            String inputCommand = scanner.nextLine();
            commandChoicer.chooseCommand(inputCommand.split("\\s+"));
        }
    }
}
