package homeworks.vladyslav_lazin.hw_2024.hw_14_01_24.strategy;

public class Main {
    public static void main(String[] args) {
        OperationService.execute(2, 3, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a + b;
            }
        });
        OperationService.execute(12, 2, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a -b;
            }
        });
        OperationService.execute(5, 5, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a * b;
            }
        });
        OperationService.execute(5, 5, new Strategy() {
            @Override
            public double doOperation(int a, int b) {
                return a / b;
            }
        });
    }
}
