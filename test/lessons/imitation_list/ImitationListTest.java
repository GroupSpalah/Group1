package lessons.imitation_list;

import homeworks.imitation_list.ImitationList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImitationListTest {
    private ImitationList list = new ImitationList(5);

    @Before
    public void clearArray() {
        list.setArray(new int[2]);
    }

    @Test
    public void shouldAddElementToArrayValueNotZero() {
        list.addElement(7);
        list.addElement(9);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{7, 9}, array);
        Assert.assertEquals(7, array[0]);
        Assert.assertEquals(9, array[1]);
    }

    @Test
    public void shouldAddElementToArrayValueIsZero() {
        list.addElement(7);
        list.addElement(0);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{7, 0}, array);
    }

    @Test
    public void shouldResizeArray() {
        list.addElement(7);
        list.addElement(9);
        list.addElement(4);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{7, 9, 4, 0}, array);
    }
}
