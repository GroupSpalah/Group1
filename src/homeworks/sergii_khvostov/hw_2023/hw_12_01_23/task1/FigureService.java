package homeworks.sergii_khvostov.hw_2023.hw_12_01_23.task1;

public class FigureService {
    public static void main(String[] args) {

        Parallelogram parallelogram = new Parallelogram(5, 5);
        System.out.println(parallelogram.calculateSquare());

        Triangle triangle = new Triangle(5, 5);
        System.out.println(triangle.calculateSquare());

        Romb romb = new Romb(5, 5);
        System.out.println(romb.calculateSquare());
    }
}
