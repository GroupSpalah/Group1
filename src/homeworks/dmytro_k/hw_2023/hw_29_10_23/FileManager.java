package homeworks.dmytro_k.hw_2023.hw_29_10_23;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileManager {

    private FigureService figureService;
    private final String FILENAME = "Figure.fig";
    private final Path FILE_PATH = Paths.get("src/homeworks/dmytro_k/hw_2023/hw_29_10_23/figure_files/" + FILENAME);

    public FileManager() {
        this.figureService = new FigureService();
    }

    public void writeToFile() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH.toFile());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(figureService.getFigureList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readFile() {
        try {
            FileInputStream fileInputStream = new FileInputStream(FILE_PATH.toFile());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            figureService.setFigureList((List<Figure>) objectInputStream.readObject());
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
