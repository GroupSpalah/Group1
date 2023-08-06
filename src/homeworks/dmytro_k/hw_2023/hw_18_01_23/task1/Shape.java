package homeworks.dmytro_k.hw_2023.hw_18_01_23.task1;

/*1) Пожалуйста, создайте абстрактный класс Shape и два подкласса Square и Circle. Заменить код в методе drawShape()
в соответствии с принципами полиморфизма. Пожалуйста, предложите другие решения для улучшения качества кода.*/

public abstract class Shape {

    private ShapeName name;
    private double radius;
    private double side1;
    private double side2;

    public Shape(ShapeName name, double radius) {
        this.name = name;
        this.radius = radius;
    }

    public Shape(ShapeName name, double side1, double side2) {
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
    }

    public ShapeName getName() {
        return name;
    }

    public void setSide2(double side2) { //?проверка
        this.side2 = side2;
    }

    abstract void drawShape();
}
