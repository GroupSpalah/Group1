package homeworks.dmytro_m.hw_2022.home_work_25_09_2022;

public class Task2 {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 6, 3, 2, 2},
                {2, 4, 5, 5, 2},
                {5, 7, 3, 8, 4},
                {5}
        };

        int count = 0;
        int x = 1;
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == x) {
                    count++;
                }
            }
        System.out.println(count);

    }
}
//    В двумерном массиве целых чисел определить, сколько раз в нем встречается элемент со значением X.