package homeworks.dmytro_k.hw_2023.hw_12_01_23.task1;

/*Создать абстрактный класс Figure с полями(длина стороны, высота), который реализует интерфейс Calculatable.*/

public abstract class Figure implements Calculatable {

    private double height;
    private double sideLength;
    private String name;

    public Figure(double height, double sideLength, String name) {
        this.height = height;
        this.sideLength = sideLength;
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public double getSideLength() {
        return sideLength;
    }

    public String getName() {
        return name;
    }

    public double calculateSquare() {
        return getHeight() * getSideLength();
    }
}
