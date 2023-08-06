package homeworks.dmytro_k.hw_2022.hw_04_12_22;

import java.util.Random;

public class Calculator {

    public int getOperandOne() {
        return new Random().nextInt(50);
    }

    public int getOperandTwo() {
        return new Random().nextInt(50);
    }

    public int sum() {
        return getOperandOne() + getOperandTwo();
    }

    public int difference() {
        return getOperandOne() - getOperandTwo();
    }
    public int multiplication() {
        return getOperandOne() * getOperandTwo();
    }
    public int division() {
        return getOperandOne() / getOperandTwo();
    }
    public int modulo() {
        return getOperandOne() % getOperandTwo();
    }
}
