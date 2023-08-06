package lessons.inheritance;

public class BlockInitialisation {
    public static void main(String[] args) {
        new ChildBlock();
    }
}

class ParentBlock {

    static {
        System.out.println("Static block initialization Parent");//1
    }

    {
        System.out.println("Non-static block initialization Parent");//2
    }

    public ParentBlock() {
        super();
        System.out.println("Constructor Parent");//3

    }
}
// 1 4 2 5 3 6
class ChildBlock extends ParentBlock {

    static {
        System.out.println("Static block initialization Child");//4
    }

    {
        System.out.println("Non-static block initialization Child");//5
    }

    public ChildBlock() {
        System.out.println("Constructor Child");//6
    }
}
