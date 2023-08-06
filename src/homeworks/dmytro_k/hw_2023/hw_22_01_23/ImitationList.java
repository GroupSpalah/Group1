package homeworks.dmytro_k.hw_2023.hw_22_01_23;

/*  Создать имитацию коллекции(с помощью массива) ArrayList для работы с типом int.

        Создать класс с полем типа одномерный массив.

        Класс должен выполнять следующие операции:

        +1) добавление элементов.
        ++2) изменение/удаление элементов по индексу.
        ++3) увеличение длины массива на заданное количество элементов.
        ++4) уменьшение длины массива до заданного количество элементов.
        ++5) вывод элементов в консоль в прямом и обратном порядке.
        ++6) сортировка массива методом пузырька
        (http://study-java.ru/uroki-java/urok-11-sortirovka-massiva/).
        +/-7) добавление массива в массив(контактенация).
        Логика должна выдавать такие  результаты при следующих входящих данных
        - 4 5 6 9 0 0 0 0 + 1 2 3 -> 4 5 6 9 1 2 3 0
        - 4 5 6 9 0 + 1 2 3 -> 4 5 6 9 1 2 3
        8) удалять дубликаты. 4 5 6 4 9 0 -> 4 5 6 9 0
        ++9) Поиск индекса первого вхождения элемента методом линейного поиска.
        если массив 4 1 2 3 7 2 и мы ищем первое вхождение 2, то надо вернуть
        индекс на котором впервые встретилась 2
        ++10) Перемешивание элементов листа в случайном порядке.

        SHUFFLING

        Random random = new Random();

        for (int i = array.length - 1; i > 1; i--) {
        int j = random.nextInt(i);

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        }

        ++При удалении элемента не обнулять его, а удалять физически.
        ++Условие добавления: перезаписывать если элемент равен 0;
        ++Число 0 добавлять нельзя.
        ++В задаче не использовать методы класса Arrays, System(кроме System.out.print(println)) и коллекции.
        ++Предусмотреть переполнение массива.*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.util.Random;

public class ImitationList {

    Log log = new Log();

    private int[] array;

    private Path path = Paths.get("src/homeworks/dmytro_k/hw_2023/hw_22_01_23./Logs.txt");

    public ImitationList(int size) {
        array = new int[size];
    }

    public void addElement(int value) throws IOException {

        Files.writeString(path, LocalDateTime.now() + "\naddElement, incoming param: "
                + value + "\n---------------\n",
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        byte[] bytes = Files.readAllBytes(path);///????
        String text = new String(bytes);///????
        System.out.println(text);///????

        if (value == 0) {
            System.out.println("Incorrect value. Value must not be null");
        } else {
            resize();

            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = value;
                    break;
                }
            }
        }
    }

    private void resize() throws IOException {

        String methodName = "resize";


        if (array[array.length - 1] != 0) {
            int[] temp = new int[array.length * 2];

            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }

            array = temp;
        }
    }

    public void changeElementByIndex(int index, int value) throws IOException { //2.1

        String methodName = "changeElementByIndex";


        if (index < 0 || index > array.length - 1) {
            System.out.println("Incorrect index");
            return;
        }

        if (value == 0) {
            System.out.println("Incorrect value");
            return;
        }

        array[index] = value;
    }

    public void deleteElementByIndex(int index) throws IOException { //2.2

        String methodName = "deleteElementByIndex";


        if (index >= 0 && index < array.length) {

            int[] temp = new int[array.length - 1];

            for (int i = 0; i < index; i++) {
                temp[i] = array[i];
            }

            for (int j = index + 1; j < array.length; j++) {
                temp[j - 1] = array[j];
            }

            array = temp;

        } else {
            System.out.println("\nIncorrect index");
        }
    }

    public void increaseArray(int amountOfElements) throws IOException { //3

        String methodName = "increaseArray";


        if (amountOfElements > 0) {
            int[] temp = new int[array.length + amountOfElements];

            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }

            array = temp;

        } else {
            System.out.println("Incorrect value");
        }
    }

    public void reduceArrayTo(int amountOfElements) throws IOException {

        String methodName = "reduceArrayTo";


        if (amountOfElements > 0 && amountOfElements < array.length) {
            int[] temp = new int[amountOfElements];

            for (int i = 0; i < temp.length; i++) {
                temp[i] = array[i];
            }

            array = temp;

        } else {
            System.out.println("Incorrect value");
        }
    }

    public void printArrayInDirectOrder() throws IOException {  // 5.1

        String methodName = "printArrayInDirectOrder";


        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public void printArrayInReverseOrder() throws IOException {  // 5.2

        String methodName = "printArrayInReverseOrder";


        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + "\t");
        }
    }

    public void bubbleSort() throws IOException { //6

        String methodName = "bubbleSort";
//        log.writeLog(methodName);

        boolean isSorted = false;

        int buffer;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] > array[i + 1]) {
                    isSorted = false;

                    buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                }
            }
        }
    }

    public void concatenation(int[] arrayInput) throws IOException { //7

        String methodName = "concatenation";


        int count = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                count++;
            }
        }

        int isFirstZero = array.length - count;

        if (arrayInput.length > count) {
            increaseArray(arrayInput.length - count);
        }

        for (int i = isFirstZero, j = 0; i < array.length; i++, j++) {

            if (j == arrayInput.length) {
                break;
            }
            array[i] = arrayInput[j];
        }
    }

    public void removeDuplicates() throws IOException {

        String methodName = "removeDuplicates";


        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] == array[i]) {
                    //System.out.print("j" + array[j] + "\t");
                    deleteElementByIndex(j);
                    --j; // пересмотреть
                    //System.out.print("j." + array[j] + "\t");
                }
            }
        }
    }

    public void findElement(int element) throws IOException { // 9)

        String methodName = "findElement";


        int count = 0;

        for (int i = 0; i < array.length; i++) {

            if (element == array[i]) {
                System.out.print("\nIndex: " + i);
                count++;
                break;
            }
        }

        if (count == 0) {
            System.out.println("\nArray does not contain such element");
        }
    }

    public void shuffling() throws IOException {

        String methodName = "shuffling";


        Random random = new Random();

        for (int i = 1; i < array.length; i++) { // пересмотреть
            int j = random.nextInt(i);
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }
}
