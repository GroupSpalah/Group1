package homeworks.dmytro_k.hw_2022.hw_16_10_22;

public class TestList {
    public static void main(String[] args) {

        ImitationList list = new ImitationList(6);
        list.addElement(1);
        list.addElement(1);
        list.addElement(1);
        list.addElement(2);
        list.addElement(2);
        list.addElement(2);
        list.printArrayInDirectOrder();
        list.findElement(3);
        list.increaseArray(3);
        System.out.println();
        list.printArrayInReverseOrder();

        list.reduceArrayTo(8);
        list.printArrayInDirectOrder();
        System.out.println();
        list.increaseArray(8);
        System.out.println();
        list.printArrayInReverseOrder();
        list.addElement(3);
        list.addElement(3);
        list.addElement(3);
        list.addElement(4);
        list.addElement(4);
        list.addElement(4);
        list.addElement(5);
        list.addElement(5);
        list.addElement(5);
        list.addElement(5);
        System.out.println();
        list.changeElementByIndex(5, 88);
        System.out.println();
        list.printArrayInDirectOrder();
        list.deleteElementByIndex(3);
        System.out.println();
        list.printArrayInDirectOrder();
        System.out.println();
        list.printArrayInDirectOrder();

        list.addElement(1);
        list.addElement(1);
        list.addElement(1);
        list.addElement(2);
        list.addElement(2);
        list.addElement(3);
        list.addElement(3);
        list.addElement(3);
        System.out.println();
        list.printArrayInDirectOrder();
        list.removeDuplicates();
        System.out.println();
        list.concatenation(new int[]{0,0,0,0,0});
        list.printArrayInDirectOrder();
        list.concatenation(new int[]{1,1,1});
        System.out.println();
        list.printArrayInDirectOrder();
        System.out.println();
        list.shuffling();
        System.out.println();
        list.printArrayInDirectOrder();
    }
}
