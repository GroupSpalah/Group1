package homeworks.sergii_khvostov.hw_2022.hw_25_09_22_twoDimArrays;

//@Khvostov

/*Создайте функцию, которая возвращает общее количество шагов,
необходимых для преобразования каждого элемента в максимальный элемент в массиве.
Каждый шаг состоит из увеличения цифры на единицу.
Примечание:
Если массив содержит только одинаковые цифры, вернуть 0.*/

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] array = new int[3][4];

        int steps = totalQuantitySteps(array);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; ++j) {

                array[i][j] = random.nextInt(1, 12);
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.print("Steps: " + steps + " ");
    }

    private static int totalQuantitySteps(int[][] array) {
        int count = 0;
        int maxValue = array[0][0];

        for (int i = 1; i < array.length; i++) {
            for (int j = 1; j < array[i].length; ++j) {

                if (array[i][j] > maxValue) {
                    maxValue = array[i][j];
                }

                if (array[i][j] == maxValue) {
                    count++;
                }
            }
        }
        return count;
    }
}

