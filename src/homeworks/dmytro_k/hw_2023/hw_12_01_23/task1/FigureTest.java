package homeworks.dmytro_k.hw_2023.hw_12_01_23.task1;


public class FigureTest {

    public static void main(String[] args) {

        Rhombus rhombus1 = new Rhombus(2, 5, "rhombus");
        double rhombusSquare = rhombus1.calculateSquare();
        rhombus1.print(rhombus1.getName());
        System.out.println("square: " + rhombusSquare);

        Triangle triangle1 = new Triangle(2, 5, "triangle");
        double triangleSquare = triangle1.calculateSquare();
        triangle1.print(triangle1.getName());
        System.out.println("square: " + triangleSquare);

        Parallelogram parallelogram1 = new Parallelogram(3, 4, "parallelogram");
        double parallelogramSquare = parallelogram1.calculateSquare();
        parallelogram1.print(parallelogram1.getName());
        System.out.println("square: " + parallelogramSquare);
    }
}
