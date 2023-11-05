package homeworks.dmytro_k.hw_2023.hw_29_10_23;

/**
 * Создайте классы Square и Rectangles с методами вычисления периметра и квадрата.
 * Дайте свои предложения по поводу отношений между классами
 * (is-a, has-a, use-a и т.д.). - внимание на занятии
*/

public class Square extends Figure {
    public Square(double side) {
        super(side, side);
    }
}
