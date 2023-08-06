package homeworks.dmytro_k.hw_2023.hw_12_01_23.task2_1;

public class FigureTest {

    public static void main(String[] args) {

    Square square1 = new Square(4);
    Circle circle1 = new Circle(5);

    double squareArea = square1.calculateArea();
    double squarePerimeter = square1.calculatePerimeter();
        System.out.println("Area " + squareArea + " Perimeter " + squarePerimeter);

    double circleArea = circle1.calculateArea();
    double circlePerimeter = circle1.calculatePerimeter();
        System.out.println("Area " + circleArea + " Perimeter " +  circlePerimeter);
    }
}
