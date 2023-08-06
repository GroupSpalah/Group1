package lessons;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.sql.SQLDataException;

public class LearnExceptions {
    public static void main(String[] args) {
//        throw new NullPointerException("NPE");
        try {
            print1();
            print2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print() {
        try {
            //complex logic
            throw new IOException();//call to method
            //complex logic
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public static void print1() throws IOException {
        throw new IOException();//call to method
    }

    public static void print2() throws IOException {
        throw new IOException();//call to method
    }

    public static void print3() {
        try {
            if (1 == 1) {
                throw new IOException();
                //complex logic and thrown unchecked exception
            } else {
                throw new SQLDataException();
            }
        } catch (IOException e) {

        } catch (SQLDataException e) {

        } catch (Exception e) {

        }
    }

    public static void print4() {
        try {
            if (1 == 1) {
                throw new IOException();
                //complex logic and thrown unchecked exception
            } else {
                throw new SQLDataException();
            }
        } catch (IOException | SQLDataException e) {
//            e = new IOException();
        }

        System.out.println();
    }

    public static void print7() throws Exception {
        if (1 == 1) {
            throw new IOException();
        }
        throw new SQLDataException();

    }

    public static void print8() throws Exception {

            throw new IOException();

//        throw new SQLDataException();

    }

    public static void print5() {
        try {
            //open connection to database
            throw new IOException();
//            System.exit(5);
        } catch (IOException e) {

        } finally {
            //close connection to database
            System.out.println("Finally");
        }

//        System.out.println("He");
    }

    public static void print6() throws SQLDataException {
        try {
            throw new IOException();
        } catch (IOException e) {
            e = new FileAlreadyExistsException("");
            throw new SQLDataException();
        }
    }

    public static void print9() throws SeregaException {
       throw new SeregaException("");
    }
}

class SeregaException extends IOException {
    public SeregaException(String message) {
        super(message);
    }
}
