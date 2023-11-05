package homeworks.dmytro_k.hw_2023.hw_29_10_23;

/**
 * ++ Напишите код для чтения и записи коллекций этих объектов из(в) файла.*/

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    private final String FILE_NAME = "Figures.fig";
    private final Path FILE_PATH = Paths.get("src/homeworks/dmytro_k/hw_2023/hw_29_10_23/figure_file/" +
            FILE_NAME);

    public void writeToFile(FigureService figureService) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH.toFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(figureService.getFigureList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public void readFile(FigureService figureService) {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH.toFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<Figure> figureList = (List<Figure>) objectInputStream.readObject();
            figureService.setFigureList(figureList);
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
