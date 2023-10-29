package lessons.learn_serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class LearnSerialization {
    public static void main(String[] args) {
        ManSer john = new ManSer("John", 32);

        String fileName = "Man.dat";

//        Paths.get("").toFile()

       /* try(FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(john);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/

        try (FileInputStream fis = new FileInputStream(fileName);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            ManSer manSer = (ManSer) ois.readObject();

            System.out.println(manSer);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class ManSer implements Serializable {
    private String name;
    private int age;

    public ManSer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "ManSer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
