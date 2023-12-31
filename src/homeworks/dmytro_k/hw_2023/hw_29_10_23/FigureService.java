package homeworks.dmytro_k.hw_2023.hw_29_10_23;

/**
 * ++ Найдите объект максимальной площади. взять из файла
 * ++ Найти объект с максимальным периметром. взять из файла фигура
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FigureService {

    private List<Figure> figureList;

    public FigureService() {
        this.figureList = new ArrayList<>();
    }

    public List<Figure> getFigureList() {
        return figureList;
    }

    public void setFigureList(List<Figure> figureList) {
        this.figureList = figureList;
    }

    public void addFigure(Figure figure) {
        figureList.add(figure);
    }

    public void maxPerimeter() {
        System.out.println("Max. perimeter: ");
        Comparator<Figure> comparatorPerimeter = Comparator.comparingDouble(Figure::calculatePerimeter);
        figureList
                .stream()
                .max(comparatorPerimeter)
                .ifPresent(System.out::println);
    }

    public void maxArea() {
        System.out.println("Max. area: ");
        Comparator<Figure> comparatorArea = Comparator.comparingDouble(Figure::calculateAreA);
        figureList
                .stream()
                .max(comparatorArea)
                .ifPresent(System.out::println);
    }
}
