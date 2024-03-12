package homeworks.vladyslav_lazin.hw_2024.hw_14_01_24.strategy;

public class OperationService {
    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }
}
