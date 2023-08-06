package homeworks.sergii_khvostov.hw_2023.hw_19_03_23.exception_overload_override;

/*import java.io.FileNotFoundException;
import java.io.IOException;

//import static sun.jvm.hotspot.HelloWorld.e;

public class Try {


    public void print() {


        if (1 == 1) {
            throw new IllegalArgumentException();  //используется инструкция throw после инструкции if, без блока catch
        }
        throw new NullPointerException();
          catch(Exception e){                   //неправильно расположен блок catch. Блок catch должен следовать за блоком try
            System.out.println(e.getMessage());
        } catch(NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

    public void printMessage() {
        try {
            if (1 == 1) {
                throw new IllegalArgumentException();
            }
            throw new NullPointerException();
        }
        finalize() {
            throw new IOException();
        }

    }

    public void getPatient() {    //используется две инструкции throw подряд
        throw new IOException();
        throw new NullPointerException();
    }

    protected void getClient() throws FileNotFoundException {
        try {
            throw new FileNotFoundException();
        } finally {
            throw new IOException();
        }
        throw new NullPointerException(); // используется инструкция throw после блока finally
    }


    public int getMessage() {
        try {
            return 1;
        } catch (IllegalArgumentException | NullPointerException e) {

        } finally {
            return 2;
        }

    }

    public int getNumberOfFiles() throws FileNotFoundException {
        try {
            return 1;
        } catch (IllegalArgumentException | NullPointerException e) {
            e = new NullPointerException();  //в блоке catch переменной e присваивается новое значение

        } finally {
            throw new NullPointerException();  //после блока finally используется инструкция throw
        }

    }

    public static void main(String[] args) {  //не обрабатывается исключение FileNotFoundException, которое может быть выброшено в методе getClient()
        Try aTry = new Try();
        System.out.println(aTry.getMessage());// what will be print in console

        try {
            aTry.getClient();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());  //вызывается метод getMessage(), который возвращает значение 2, независимо от того, было ли выброшено исключение в блоке try
        }
    }
}*/
