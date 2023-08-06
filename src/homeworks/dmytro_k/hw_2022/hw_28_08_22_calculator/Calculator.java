package homeworks.dmytro_k.hw_2022.hw_28_08_22_calculator;

public class Calculator {
    public static void main(String[] args) {

        int a = 25;
        int b = 7;

        int x = a + b;
        int y = a - b;
        int c = a / b;
        int d = a * b;
        int i = a % b;

        System.out.println("число 1: " + a + ";" + " число 2: " + b + ";" +
                "\nРезультаты мат. операций:" +
                "\nсумма: " + x +
                "\nразница: " + y +
                "\nчастное: " + c +
                "\nпроизведение: " + d +
                "\nостаток от деления: " + i);
    }
}
