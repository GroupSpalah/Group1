package lessons.generic;

public class LearnGenerics {
    public static void main(String[] args) {
        CalculatorGeneric<Integer> calculatorGenericInt = new CalculatorGeneric<>(5, 8);
        CalculatorGeneric<Double> calculatorGenericDouble = new CalculatorGeneric<>(5.0, 2.0);
        CalculatorGeneric1<Double, Byte> calculator1 = new CalculatorGeneric1<>(5.0, (byte) 2);

        GenericMethod.<Integer>print(5);
    }
}

class CalculatorInt {
    private int value1;
    private int value2;
}

class CalculatorDouble {
    private double value1;
    private double value2;
}

class CalculatorGeneric<T extends Number> {
    private T value1;
    private T value2;

    public CalculatorGeneric(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public int compare() {

        boolean b = value1.intValue() > value2.intValue();

        if (b) {

        }

//        boolean b1 = 5 > 2;

        return 0;
    }

}

class CalculatorGeneric1<T extends Number, F extends Comparable<F>> {
    private T value1;
    private F value2;

    public CalculatorGeneric1(T value1, F value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public void print(T t) {
        System.out.println(t);
    }

}

class GenericMethod {
    public static <T extends Comparable<T>> void print(T t) {
        System.out.println(t);
    }
}

