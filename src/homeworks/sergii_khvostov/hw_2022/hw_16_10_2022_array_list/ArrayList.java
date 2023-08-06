package homeworks.sergii_khvostov.hw_2022.hw_16_10_2022_array_list;

//@Khvostov

/*Создать имитацию коллекции(с помощью массива) ArrayList для работы с типом int.

Создать класс с полем типа одномерный массив.

Класс должен выполнять следующие операции:

1) добавление элементов.+
2) изменение/удаление элементов по индексу.+/-
3) увеличение длины массива на заданное количество элементов.
4) уменьшение длины массива до заданного количество элементов.
5) вывод элементов в консоль в прямом и обратном порядке.
6) сортировка массива методом пузырька
(http://study-java.ru/uroki-java/urok-11-sortirovka-massiva/).
7) добавление массива в массив(контактенация).
	Логика должна выдавать такие  результаты при следующих входящих данных
	 - 4 5 6 9 0 0 0 0 + 1 2 3 -> 4 5 6 9 1 2 3 0
	 - 4 5 6 9 0 + 1 2 3 -> 4 5 6 9 1 2 3
8) удалять дубликаты. 4 5 6 4 9 0 -> 4 5 6 9 0
9) Поиск индекса первого вхождения элемента методом линейного поиска,
 если массив 4 1 2 3 7 2 и
 мы ищем первое вхождение 2, то надо вернуть индекс на котором впервые встретилась 2
10) Перемешивание элементов листа в случайном порядке.

SHUFFLING

	Random random = new Random();

        for (int i = array.length - 1; i > 1; i--) {
            int j = random.nextInt(i);

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

При удалении элемента не обнулять его, а удалять физически.
Условие добавления: перезаписывать если элемент равен 0;
Число 0 добавлять нельзя.
В задаче не использовать методы класса Arrays, System(кроме System.out.print(println)) и коллекции.
Предусмотреть переполнение массива.*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Random;

public class ArrayList {
    private int[] array;

    public ArrayList(int size) {
        array = new int[size];
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    Path path = Paths.get("./Logs.txt");

    public void createFile() throws IOException {
        Files.createFile(path);
    }

    public void addElement(int value) throws IOException {
        String log = "\naddElement, incoming param: " + value;
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);


        if (value == 0) {
            System.out.println("Incorrect value");
            return;
        }

        resize();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = value;
                break;
            }
        }
    }

    private void resize() throws IOException {
        String log = "\nresize";
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        if (array[array.length - 1] != 0) {
            int[] temp = new int[array.length * 2];

            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }
            array = temp;
        }
    }

    public void changeElementByIndex(int index, int value)
            throws IOException {
        String log = "\nchangeElementByIndex, incoming param: "
                + index + " " + value;
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

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

    public void deleteElementByIndex(int index) throws IOException {
        String log = "\ndeleteElementByIndex, incoming param: " + index;
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        if (index < 0 || index > array.length - 1) {
            System.out.println("Incorrect index");
            return;
        }

        int[] temp = new int[array.length - 1];

        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }

        for (int i = index; i < temp.length; i++) {
            temp[i] = array[i + 1];
        }

        array = temp;
    }

    public void increasingLengthArray(int value) throws IOException {
        String log = "\nincreasingLengthArray, incoming param: " + value;
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        int[] temp = new int[array.length + value];

        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public void decreaseLengthArray(int value) throws IOException {
        String log = "\ndecreaseLengthArray, incoming param: " + value;
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        if (value >= array.length || value == 0) {
            System.out.println("Incorrect value");
            return;
        }

        int[] temp = new int[value];

        for (int i = 0; i < temp.length; i++) {
            temp[i] = array[i];

            array = temp;
        }
    }

    public void printElements() throws IOException {
        String log = "\nprintElements";
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public void printReversElements() throws IOException {
        String log = "\nprintReversElements";
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + "\t");
        }
    }

    public void bubbleSortArray(int[] array) throws IOException {
        String log = "\nbubbleSortArray, incoming param: " +
                Arrays.toString(array);
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        for (int i = this.array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int sort = this.array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = sort;
                }
            }
        }
    }

    public void addArrayToArray(int[] addArray) throws IOException {
        String log = "\naddArrayToArray, incoming param: " +
                Arrays.toString(addArray);
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        int countZeros = 0;

        for (int element : array) {
            if (element == 0) {
                ++countZeros;
            }
        }

        int positionFirstZero = array.length - countZeros;

        if (countZeros < addArray.length) {
            increasingLengthArray(addArray.length - countZeros);
        }

        for (int i = positionFirstZero, j = 0; j < addArray.length; i++, ++j) {
            array[i] = addArray[j];
        }
    }

    public void deleteDuplicates() throws IOException {
        String log = "\ndeleteDuplicates";
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    deleteElementByIndex(i);
                    --j;
                }
            }
        }
    }

    public void searchIndexFirstElement(int value) throws IOException {
        String log = "\nsearchIndexFirstElement, incoming param: " + value;
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);

        boolean isValue = false;

        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                System.out.print(i);
                isValue = true;
                break;
            }
        }

        if (!isValue) {
            System.out.println("There isn't searched element");
        }
    }

    public void mixArray() throws IOException {
        String log = "\nmixArray";
        Files.write(path, log.getBytes(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        byte[] bytes = Files.readAllBytes(path);
        String text = new String(bytes);
        System.out.println(text);
        Random random = new Random();

        for (int i = array.length - 1; i > 1; i--) {
            int j = random.nextInt(i);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}




