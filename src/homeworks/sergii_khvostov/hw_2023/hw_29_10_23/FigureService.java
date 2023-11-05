package homeworks.sergii_khvostov.hw_2023.hw_29_10_23;


import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class FigureService {
    private List<Figure> figures;

    public FigureService() {
        figures = new ArrayList<>();
    }

    public void addFigure(Figure figure) {
        figures.add(figure);
    }

    public void inFileFigures(String fileName) {
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(figures);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Figure> outFileFigures(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            return (List<Figure>) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void findMaxSquare(String fileName) {
        List<Figure> figureList = outFileFigures(fileName);
        Optional<Figure> maxFigure = figureList.stream()
                .max(Comparator.comparing(Figure::CalcSquare));

        maxFigure.ifPresent(figure -> System.out.println("Max " + figure.getClass().getSimpleName() +
                " (Square: " + figure.CalcSquare() + ")"));

    }

    public void findMaxPerimeter(String fileName) {
        List<Figure> figureList = outFileFigures(fileName);
        Optional<Figure> maxFigure = figureList.stream()
                .max(Comparator.comparing(Figure::CalcPerimeter));

        maxFigure.ifPresent(figure -> System.out.println("Max " + figure.getClass().getSimpleName() +
                " (Perimeter: " + figure.CalcPerimeter() + ")"));
    }
}
