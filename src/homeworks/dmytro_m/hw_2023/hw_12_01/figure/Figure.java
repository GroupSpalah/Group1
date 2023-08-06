package homeworks.dmytro_m.hw_2023.hw_12_01.figure;

public abstract class Figure implements Calculatable {

    private double figureLength;
    private double figureHeight;

    public Figure(double figureLength, double figureHeight) {
        this.figureLength = figureLength;
        this.figureHeight = figureHeight;
    }

    public double getFigureLength() {
        return figureLength;
    }

    public double getFigureHeight() {
        return figureHeight;
    }
}
//Создать абстрактный класс Figure с полями(длина стороны, высота), который реализует интерфейс Calculatable.
//        Создать классы Triangle, Parallelogram, Romb. В классах наследниках переопределить метод calculateSquare,
//        для расчета площади. Протестировать функционал.