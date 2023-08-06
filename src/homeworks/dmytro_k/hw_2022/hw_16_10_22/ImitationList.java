package homeworks.dmytro_k.hw_2022.hw_16_10_22;

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

import java.util.Random;

public class ImitationList {

    private int[] array;

    //TODO for test
    public int[] getArray() {
        return array;
    }

    //TODO for test
    public void setArray(int[] array) {
        this.array = array;
    }

    public ImitationList(int size) {
        array = new int[size];
    }

    public void addElement(int value) {

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

    private void resize() {

        if (array[array.length - 1] != 0) {
            int[] temp = new int[array.length * 2];

            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }

            array = temp;
        }
    }

    public void changeElementByIndex(int index, int value) { //2.1

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

    public void deleteElementByIndex(int index) { //2.2

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

        // alternative

/*        if (index < 0 || index > array.length - 1) {
            System.out.println("\nIncorrect index");
            return;
        }

        int[] temp = new int[array.length - 1];

        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }

        for (int j = index + 1; j < array.length; j++) {
            temp[j - 1] = array[j];
        }

        array = temp;*/
    }

    public void increaseArray(int amountOfElements) { //3

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

    public void reduceArrayTo(int amountOfElements) {

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

    public void printArrayInDirectOrder() {  // 5.1

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    public void printArrayInReverseOrder() {  // 5.2

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + "\t");
        }
    }

    public void bubbleSort() { //6

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

/*    public void concatenation(int[] arrayInput) { //7

        int countZeros = 0;

        for (int elem : array) {
            if (elem == 0) {
                countZeros++;
            }
        }

        int positionFirstZero = array.length - countZeros;

        if (countZeros < arrayInput.length) {
            increaseArray(arrayInput.length - countZeros);
        }

        for (int i = positionFirstZero, j = 0; i < array.length; i++, ++j) {
            array[i] = arrayInput[j];
        }

    }*/

    public void concatenation(int[] arrayInput) { //7

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

    public void removeDuplicates() {

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

    // не работает
/*    public void removeDuplicates() {

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    deleteElementByIndex(i);
                    --j;
                }
            }
        }
    }*/

    public void findElement(int element) { // 9)

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

/*    public int findElement(int element) { // 9)

        int count = 0;
        int desiredIndex = 0;

        for (int i = 0; i < array.length; i++) {

            if (element == array[i]) {
                desiredIndex = i;
                System.out.print("\nIndex: " + desiredIndex);
                count++;
                break;
            }
        }

        if (count == 0) {
            System.out.println("\nArray does not contain such element");
            //TODO for test
            desiredIndex = -1;
        }

        return desiredIndex;
    }*/

    public void shuffling() {

        Random random = new Random();

        for (int i = 1; i < array.length; i++) { // пересмотреть
            int j = random.nextInt(i);
            int temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
    }
}
