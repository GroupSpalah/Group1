package homeworks.vladyslav_lazin.hw_2023.hw_29_10_23;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ShapeService {
    private static final File FILE = Paths.get("./src/homeworks/vladyslav_lazin/hw_2023/hw_29_10_23/shapes.dat").toFile();
    public static void writeShapesToFile(List<Shape> shapes) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
            outputStream.writeObject(shapes);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static List<Shape> readShapesFromFile() {
        List<Shape> shapes = new ArrayList<>();
        try(FileInputStream fileInputStream = new FileInputStream(FILE);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
            shapes = (List<Shape>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return shapes;
    }
    public static Shape findMaximalPerimeterShape(List<Shape> shapes) {
        return shapes.stream()
                .sorted((a, b) -> -Float.compare(a.getPerimeter(), b.getPerimeter()))
                .toList().get(0);
    }
    public static Shape findMaximalSquareShape(List<Shape> shapes) {
        return shapes.stream()
                .sorted((a, b) -> -Float.compare(a.getSquere(), b.getSquere()))
                .toList().get(0);
    }
}
