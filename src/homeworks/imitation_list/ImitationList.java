package homeworks.imitation_list;

public class ImitationList {
    private int[] array;

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public ImitationList(int size) {
        array = new int[size];
    }

    public void addElement(int value) {

        if (value == 0) {
            System.out.println("0 nelzya");
        } else {
            resize();

            for (int i = 0; i < array.length; i++) {
                if (array[i] == 0) {
                    array[i] = value;
                    break;
                }
            }
        }
    }

    private void resize() {
        if (array[array.length - 1] != 0) {
            int[] temp = new int[array.length * 2];

            for (int i = 0; i < array.length; i++) {
                temp[i] = array[i];
            }

            array = temp;
        }
    }

    public void changeElementByIndex(int index, int value) {
        if (index < 0 || index > array.length - 1) {
            System.out.println("Incorrect index");
            return;
        }

        if (value == 0) {
            System.out.println("Incorrect value");
            return;
        }

        array[index] = value;
    }
}
