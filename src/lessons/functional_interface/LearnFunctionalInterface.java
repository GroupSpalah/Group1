package lessons.functional_interface;

public class LearnFunctionalInterface {
    public static void main(String[] args) {
        Summable summable1 = (a, b) -> a + b;

        int operation = summable1.operation(5, 7);

//        System.out.println(operation);

        Summable summable2 = (a, b) -> a - b;

        Convertable<String, Integer> convertable = str -> Integer.parseInt(str);

        int result = convertable.convert("45") + 5;

        System.out.println(result);

        Convertable<String, Integer> convertable1 = new Convertable<>() {
            @Override
            public Integer convert(String s) {
                return Integer.parseInt(s);
            }
        };
    }
}

@FunctionalInterface
interface Summable {
    int operation(int a, int b);
}

@FunctionalInterface
interface Convertable<T, F> {
    F convert(T t);
}

