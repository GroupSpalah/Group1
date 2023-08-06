package lessons.learn_class.computer;

import java.util.Objects;
import java.util.Scanner;

/**
 * 1) Write Computer class, the attributes of this class is manufacturer (of String type),
 * serialNumber (of int type), price (of float type),
 * quantityCPU (of int type) and frequencyCPU (of int type).
 *
 * 2) The fields Computer class need to be encapsulated.
 * Use correct access modifiers.
 * 3) Write a program to create array of Computer objects (5 pcs.).
 * Declare array of Computer objects (5 pcs.), create 5 Computer objects and place it to array.
 * 4) Write a program that iterate through array of Computer objects and increases by 10 percent field price.
 * 5) Add to class Computer method void view(){} that prints all fields of object in line.
 * Print all info (fields) of all objects in console.
 */
public class Computer {
    private String manufacturer;
    private int serialNumber;
    private int quantityCPU;
    private int frequencyCPU;
    private float price;

    public Computer(String manufacturer, int serialNumber, int quantityCPU, int frequencyCPU, float price) {
        this.manufacturer = manufacturer;
        this.serialNumber = serialNumber;
        this.quantityCPU = quantityCPU;
        this.frequencyCPU = frequencyCPU;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void view() {
        System.out.println(quantityCPU + "\t" + price);
    }
}

class TestComputer {
    public static void main(String[] args) {

        Computer computer1 = new Computer("HP", 123, 4, 3000, 12.45f);

        Computer computer2 =
                new Computer("LENOVO", 12345, 6, 3200, 29.85f);

        //        datatype[] name = new datatype[size];

        Computer[] computers = new Computer[5];//null, 3 nulls, 2 non-null
        computers[0] = computer1;
        computers[1] = computer2;

        for (Computer computer : computers) {
            /*if (computer != null) {

            }*/

            if (Objects.nonNull(computer)) {
                float price = computer.getPrice();

//                price += price * 0.1f;
                price = price + (price * 0.1f);

                computer.setPrice(price);

                computer.view();
            }
        }
    }
}
