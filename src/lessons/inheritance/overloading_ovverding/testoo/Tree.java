package lessons.inheritance.overloading_ovverding.testoo;

public class Tree {

    protected Object print(String s) {
        System.out.println("Tree");
        return null;
    }

    protected Object print(String s, int a) {
        System.out.println("Tree");
        return null;
    }

}

/*
* private - visibility only inside class
* package - private - visibility only inside package
* protected - visibility only inside package + subclass
* public - visibility anywhere
* */
