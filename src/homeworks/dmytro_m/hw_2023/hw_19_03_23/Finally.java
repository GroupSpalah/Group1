package homeworks.dmytro_m.hw_2023.hw_19_03_23;



import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;

public class Finally {

    public void getNumberOfCars() {
        System.out.println(5);
    }

    public Object getFileName(Path path) throws FileNotFoundException {
        File file = new File("./Text.txt");
        return file;
    }

    protected String calculate(String first, int count) {
        return "2*2=4";
    }
}

