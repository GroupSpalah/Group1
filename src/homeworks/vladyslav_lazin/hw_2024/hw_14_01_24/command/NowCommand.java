package homeworks.vladyslav_lazin.hw_2024.hw_14_01_24.command;

import java.time.LocalDate;

public class NowCommand implements Command {
    @Override
    public void execute(String... args) {
//        System.out.println(System.currentTimeMillis());
        System.out.println(LocalDate.now());
    }
}
