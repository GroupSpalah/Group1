package lessons;

public class PassingParams {
    public static void main(String[] args) {
        int b = 10;

        passInt(b);

//        System.out.println(b);
        ForPass forPass = new ForPass();

        passObject(forPass);

        System.out.println(forPass.name);

        String str = "John";

        passString(str);

        System.out.println(str);
    }

    public static void passInt(int a) {
        a = 15;
    }

    public static void passObject(ForPass forPass) {
        forPass.name = "World";
    }

    public static void passString(String s) {
        s = "World";
    }
}

class ForPass {
    public String name = "Hello";
}
