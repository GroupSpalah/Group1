package homeworks.sergii_khvostov.hw_2023.hw_19_03_23.exception_overload_override;

/*import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLDataException;
import java.util.Date;

public class Catch extends Exception {

    public final void foo() {
        System.out.println("Foo");
    }


    @Override
    public Object getNumberOfCars() {
        int year = getYear();//call the method from super class
        return new Object;  //переопределяет метод из класса Exception, который возвращает void, а не Object
    }

    @Override
    public static Date getTime() {  //помечен как static, но такого модификатора нет в методе, который он переопределяет.
        return new Date();
    }

    protected Integer getPatientFromDatabase(File file, Integer number) throws SQLDataException {
        System.out.println("Integer");
        count = 1;  //не объявлена
        return count;
    }

      //Перегруженный метод getPatientFromDatabase() имеет два параметра типа int,
      //что вызывает неоднозначность при вызове метода, поскольку
      //тип int и Integer не являются полностью совместимыми.
      // В таком случае метод не перегружен, а является переопределением
      // другого метода с тем же именем и параметрами.

    private int getPatientFromDatabase(File file, int number) throws Exception {
        System.out.println("int");
        return 6;
    }

    public int getPatientFromDatabase(File file, int number, int years ) throws Exception {
        return 2;  // нет тела метода.
    }

    public File getFileName(Path path) throws IOException, SQLDataException{
        return new File("./MyFile.txt");
    }


    Object calculate(String name, Integer count, BufferedReader bufferedReader) {
        return new Object();
    }

    public static void main(String[] args) {
        Catch aCatch = new Catch();
        System.out.println(aCatch.getPatientFromDatabase(new File(""), 2));
    }

}*/
