package homeworks.dmytro_m.hw_2023.hw_12_01.figure;

public class Triangle extends Figure{

    public Triangle(double figureLength, double figureHeight) {
        super(figureLength, figureHeight);
    }

    @Override
    public double calculateSquare() {
        return (this.getFigureHeight() * this.getFigureLength())/2;
    }

}
