package homeworks.dmytro_m.hw_2023.hw_12_01.figure;

public class Test {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(3, 2);
        Parallelogram parallelogram = new Parallelogram(2, 3);
        Romb romb = new Romb(1, 2);

        triangle.calculateSquare();
        parallelogram.calculateSquare();
        romb.calculateSquare();

        triangle.print();
    }
}
