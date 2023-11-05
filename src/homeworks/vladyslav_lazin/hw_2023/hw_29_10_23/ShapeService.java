package homeworks.vladyslav_lazin.hw_2023.hw_29_10_23;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ShapeService {
    public static void writeShapesToFile(String fileName, List<Shape> shapes) {
        File file = Paths.get("./src/homeworks/vladyslav_lazin/hw_2023/hw_29_10_23/" + fileName).toFile();
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(shapes);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static List<Shape> readShapesFromFile(String fileName) {
        List<Shape> shapes = new ArrayList<>();
        File file = Paths.get("./src/homeworks/vladyslav_lazin/hw_2023/hw_29_10_23/" + fileName).toFile();
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            Object object;
            while ((object = inputStream.readObject()) != null) {
                if (object instanceof List<?>) {
                    shapes = (List<Shape>) object;
                }
            }
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
    public static Shape findMaximalSquereShape(List<Shape> shapes) {
        return shapes.stream()
                .sorted((a, b) -> -Float.compare(a.getSquere(), b.getSquere()))
                .toList().get(0);
    }
}
