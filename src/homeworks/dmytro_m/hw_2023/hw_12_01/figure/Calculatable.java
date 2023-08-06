package homeworks.dmytro_m.hw_2023.hw_12_01.figure;

public interface Calculatable {

    double calculateSquare();

    public default void print() {
        System.out.print("Figure name is " + this.getClass().getSimpleName());
    }
}
//    Создать интерфейс Calculatable с методом calculateSquare и default метод print, который печатает название фигуры.
