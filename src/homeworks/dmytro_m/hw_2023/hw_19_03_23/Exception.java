package homeworks.dmytro_m.hw_2023.hw_19_03_23;


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Date;

public class Exception {

    private int getYear() {
        return new Date().getYear();
    }
//    метод устарел

    public final void foo() {
        System.out.println("Foo");
    }
//

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void getNumberOfCars() {
        System.out.println(5);
    }

    public Object getFileName(Path path) throws FileNotFoundException {
        File file = new File("./Text.txt");
        return file;
    }

    public static Date getTime() {
        return new Date();
    }

    protected String calculate(String first, int count) {
        return "2*2=4";
    }
}
