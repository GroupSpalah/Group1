package homeworks.dmytro_k.hw_2024.hw_07_12_24.task1;

/**
 * 1) Добавить функционал добавления к строке # и {} к шаблону Декоратор, чтобы получить строку #{Hello}#
 */

public class Decorator {
    public static void main(String[] args) {
        new RightNumberSign(
                new LeftNumberSign(
                        new LeftCurlyBrace(
                                new RightCurlyBrace(
                                        new BasePrinter("Hello")))))
                .print();
    }
}