package homeworks.dmytro_m.hw_2022.hw_11_09_2022;


public class Task2 {
    public static void main(String[] args) {

//        1) Increment/Decrement
//        2) Программа должна вывести первые 10 чисел, которые делятся на 3 или 4 без остатка,
//        но цикл for выполняет итерацию от 1 до 100 (поэтому оператор break необходимо и
//        спользовать после вывода 10 результатов).
//        Результат должен выглядеть:
//        3
//        4
//   …
//        20
        int iterator = 0;
        for (int i = 1; i < 100; i++) {
            if(i % 3 == 0 || i % 4 == 0){
                iterator++;
                System.out.println(i);
                if(iterator == 10){
                    return;
                }
            }
        }
    }
}
