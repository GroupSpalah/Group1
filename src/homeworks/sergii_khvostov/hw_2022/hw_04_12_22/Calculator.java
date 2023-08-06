package homeworks.sergii_khvostov.hw_2022.hw_04_12_22;

/*1) Создать калькулятор:
Метод класса возвращает значение для операции.
Создать методы под действия *, /, -, +, %.
Создать два public метода, возвращающих случайные числа.
Каждый метод класса вызывает один из методов(возвращают случайные числа),
 чтобы получить значения для операций.
Протестировать методы, выполняющие мат. действия.
Для каждой операции в тесте возвращать разные значения используя
 Mockito(mock, spy) + verify.

class Calculator {

public int getOperandOne() {
	return new Random().nextInt(50);
}

public int getOperandTwo() {
	return new Random().nextInt(50);
}

public int sum() {
	return getOperandOne() + getOperandTwo();
}
}
2) В классе Звуки животных имеются методы которые, возвращают звуки,
   которые издают животные(Корова, кот, мышь),
   но методы написаны неправильно и возвращают неправильные значения
   (метод, который должен возвращать "Му",
   возвращает "Пи").
   С помощью библиотеки Mockito заставить методы возвращать
   корректные значения.*/

import java.util.Random;

public class Calculator {

    public int getOperandOne() {
        return new Random().nextInt(50);
    }

    public int getOperandTwo() {
        return new Random().nextInt(50);
    }

    public int add(int a, int b) {
        a  = getOperandOne();
        b = getOperandTwo();
        return a + b;
    }

    public int sub(int a, int b) {
        a = getOperandOne();
        b = getOperandTwo();
        return a - b;
    }

    public int div(int a, int b) {
        a = getOperandOne();
        b = getOperandTwo();
        return a / b;
    }

    public int mul(int a, int b) {
        a = getOperandOne();
        b = getOperandTwo();
        return a * b;
    }
}
