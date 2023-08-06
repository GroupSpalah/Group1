package lessons.inheritance;

public class Polymorphism {
    public static void main(String[] args) {

//        int a = "";

        Parent parent = new Child();//Parent parent = new Parent();

        parent.print();
    }
}

class Parent {

    public void print() {
        System.out.println("Parent");
    }

    public void print(int a) {
        System.out.println("Parent");
    }

}

class Child extends Parent {

    public void print() {
        System.out.println("Child");
    }
}