package lessons.inheritance.overloading_ovverding;

import lessons.inheritance.overloading_ovverding.testoo.Tree;

public class Oak extends Tree {
    @Override
    public String print(String a) {
        System.out.println("Oak");
        return null;
    }

    protected Object print(String s, int a) {
        System.out.println("Tree");
        return null;
    }

    public void action() {
        super.print("");
    }

}
