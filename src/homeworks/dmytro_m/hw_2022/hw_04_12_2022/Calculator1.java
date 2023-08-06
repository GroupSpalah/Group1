package homeworks.dmytro_m.hw_2022.hw_04_12_2022;

import java.util.Random;

public class Calculator1 {

    private int a;

    public int sum(int a) {
        return a + random1();
    }

    public int minus(int a) {
        return a - random2();
    }

    public int del(int a) {
        return a / random1();
    }

    public int ymn(int a) {
        return a * random2();
    }

    public int random1() {
        return new Random().nextInt(60);
    }

    public int random2() {
        return new Random().nextInt(50);
    }

}
//1) Создать калькулятор:
//        Метод класса возвращает значение для операции. Создать методы под действия *, /, -, +, %.
//        Создать два public метода, возвращающих случайные числа.
//        Каждый метод класса вызывает один из методов(возвращают случайные числа),
//        чтобы получить значения для операций.
//        Протестировать методы, выполняющие мат. действия. Для каждой операции в тесте возвращать
//        разные значения используя
//        Mockito(mock, spy) + verify.