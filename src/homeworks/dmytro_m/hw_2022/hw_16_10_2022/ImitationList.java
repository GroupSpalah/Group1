package homeworks.dmytro_m.hw_2022.hw_16_10_2022;

import java.util.Random;

public class ImitationList {

    private int[] arr;

    public ImitationList(int size) {
        arr = new int[size];
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

//            +1) добавление элементов.

    public void addElement(int num) {
        if (num == 0) {
            System.out.println("Incorrected value");
        } else {

            resize();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = num;
                    break;
                }
            }
        }

    }

    public void resize() {

        if (arr[arr.length - 1] != 0) {
            int[] tmp = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                tmp[i] = arr[i];
            }
            arr = tmp;
        }

    }

    // ++2.1) изменение/удаление элементов по индексу.
    public void changeElementByIndex(int index, int value) {

        if (index < 0 || index > arr.length - 1 || value == 0) {
            System.out.println("Error");
        } else {
            arr[index] = value;
        }

    }

//    2.2/удаление элементов по индексу.

    public void deleteElementByIndexMy(int index) {

        if (index < 0 || index > arr.length - 1) {
            System.out.println("index \n" +
                    "greater than the length of the array");
        } else {
            int[] copyArray = new int[arr.length - 1];

            for (int i = 0, j = 0; i < arr.length; i++) {

                if (i == index) {
                    continue;
                }

                copyArray[j] = arr[i];
                j++;

            }

            arr = copyArray;
        }
    }

    public void deleteElementByIndex(int index) {

        if (index < 0 || index > arr.length - 1) {
            System.out.println("Incorrect index");
            return;
        }

        int[] temp = new int[arr.length - 1];

        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }

//        for (int j = index + 1; j < arr.length; j++) {
//            temp[j - 1] = arr[j];
//        }

        for (int i = index; i < temp.length; i++) {
            temp[i] = arr[i + 1];
        }

        arr = temp;

    }


//++3) увеличение длины массива на заданное количество элементов.

    public void increaseArray(int value) {

        if (value > 0) {
            int[] arrCopy = new int[arr.length + value];

            for (int i = 0; i < arr.length; i++) {
                arrCopy[i] = arr[i];
            }

            arr = arrCopy;

        } else {
            System.out.println("Incorrect value");
        }

    }

//++4) уменьшение длины массива до заданного количество элементов.

    public void arrayReduction(int count) {

        if (count > 0 && count <= arr.length) {
            int[] copyArray = new int[arr.length - count];

            for (int i = 0; i < copyArray.length; i++) {
                copyArray[i] = arr[i];
            }

            arr = copyArray;
        } else {
            System.out.println("Error");
        }



    }

//    ++5) вывод элементов в консоль в прямом и обратном порядке.

    public void outputElementsArray() {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public void printArrayInReverseOrder() {

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

//++6) сортировка массива методом пузырька

    public void sortedArray() {
        boolean flag = false;

        int[] arrSorted = new int[arr.length];

        while (!flag) {

            flag = true;
            int temp;

            for (int i = 0; i < arr.length-1; i++) {

                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    flag = false;
                }

            }

        }
    }

//7)добавление массива в массив(контактенация).
//Логика должна выдавать такие  результаты при следующих входящих данных
//- 4 5 6 9 0 0 0 0 + 1 2 3 -> 4 5 6 9 1 2 3 0
//- 4 5 6 9 0 + 1 2 3 -> 4 5 6 9 1 2 3

    public void concatenationMy(int[] arr1) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {
                count++;
            }
        }


        if (count <= arr1.length) {

            for (int i = 0, j = 0; i < arr.length; i++) {

                if (arr[i] == 0) {
                    arr[i] = arr[j];
                    j++;
                }
            }
        } else {

            int[] array = new int[arr.length + arr1.length - count];

            for (int i = 0; i < arr.length; i++) {
                array[i] = arr[i];
            }

            for (int i = 0, j = arr.length - 1; i < arr1.length; i++, j--) {
                array[j] = arr1[i];
            }
            arr = array;
        }
    }

    public void concatenation(int[] arrayInput) { //7

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                count++;
            }
        }

        int isFirstZero = arr.length - count;

        if (arrayInput.length > count) {
            increaseArray(arrayInput.length - count);
        }

        for (int i = isFirstZero, j = 0; i < arr.length; i++, j++) {

            if(j ==arrayInput.length) {
                break;
            }
            arr[i] = arrayInput[j];
        }
    }


//    8) удалять дубликаты. 4 5 6 4 9 0 -> 4 5 6 9 0


    public void removeDuplicates() {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] == arr[i]) {
                    //System.out.print("j" + array[j] + "\t");
                    deleteElementByIndex(j);
                    --j; // пересмотреть
                    //System.out.print("j." + array[j] + "\t");
                }
            }
        }
    }

// ++9) Поиск индекса первого вхождения элемента методом линейного поиска.
//    если массив 4 1 2 3 7 2 и мы ищем первое вхождение 2, то надо вернуть
//    индекс на котором впервые встретилась 2

    public int findElement(int element) {

        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }

        return index;
    }
//    int count = 0;
//    int desiredIndex = 0;
//
//        for (int i = 0; i < array.length; i++) {
//
//        if (element == array[i]) {
//            desiredIndex = i;
//            System.out.print("\nIndex: " + desiredIndex);
//            count++;
//            break;
//        }
//    }
//
//        if (count == 0) {
//        System.out.println("\nArray does not contain such element");
//        //TODO for test
//        desiredIndex = -1;
//    }
//
//        return desiredIndex;


//        ++10) Перемешивание элементов листа в случайном порядке.

    public void shuffling() {

        Random random = new Random();

        for (int i = 1; i < arr.length; i++) { // пересмотреть
            int j = random.nextInt(i);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}
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