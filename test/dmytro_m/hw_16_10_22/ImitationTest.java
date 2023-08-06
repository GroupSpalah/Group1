package dmytro_m.hw_16_10_22;

import homeworks.dmytro_m.hw_2022.hw_16_10_2022.ImitationList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ImitationTest {

    private ImitationList list;

    @Before
    public void clearArray() {
        list = new ImitationList(2);
    }

    @Test
    public void shouldAddElement() {
        list.addElement(4);

        Assert.assertArrayEquals(new int[]{4, 0}, list.getArr());
    }

    @Test
    public void shouldAddElementByZero() {
        list.addElement(4);
        list.addElement(0);

        Assert.assertArrayEquals(new int[]{4, 0}, list.getArr());
    }

    @Test
    public void shouldResize() {
        list.addElement(4);
        list.addElement(4);
        list.addElement(4);
        Assert.assertArrayEquals(new int[]{4, 4, 4, 0}, list.getArr());
    }

    @Test
    public void shouldChangeElementByIndex() {
        list.changeElementByIndex(0, 3);
        Assert.assertArrayEquals(new int[]{3, 0}, list.getArr());
    }

    @Test
    public void shouldChangeElementByIndexIndexMore() {
        list.changeElementByIndex(5, 3);
        Assert.assertArrayEquals(new int[]{0, 0}, list.getArr());
    }

    @Test
    public void shouldChangeElementByIndexIndexLess() {
        list.changeElementByIndex(-1, 3);
        Assert.assertArrayEquals(new int[]{0, 0}, list.getArr());
    }

    @Test
    public void shouldDeleteElementByIndexMy() {
        list.setArr(new int[]{2, 6, 3, 4, 12, 6});
        list.deleteElementByIndexMy(0);
        Assert.assertArrayEquals(new int[]{6, 3, 4, 12, 6}, list.getArr());
    }

    @Test
    public void shouldDeleteElementByIndexMyIndexMore() {
        list.deleteElementByIndex(15);
        Assert.assertArrayEquals(new int[]{0, 0}, list.getArr());
    }

    @Test
    public void shouldDeleteElementByIndexMyIndexLess() {
        list.deleteElementByIndex(-1);
        Assert.assertArrayEquals(new int[]{0, 0}, list.getArr());
    }

    @Test
    public void shouldIncreaseArray() {
        list.setArr(new int[]{3, 4, 56, 2, 4});
        list.increaseArray(3);
        Assert.assertArrayEquals(new int[]{3, 4, 56, 2, 4, 0, 0, 0}, list.getArr());
    }

    @Test
    public void shouldIncreaseArrayValueLess() {
        list.increaseArray(-3);
        Assert.assertArrayEquals(new int[]{0, 0}, list.getArr());
    }

    @Test
    public void shouldArrayReduction() {
        list.setArr(new int[]{3, 4, 56, 2, 4});
        list.arrayReduction(3);
        Assert.assertArrayEquals(new int[]{3, 4}, list.getArr());
    }

    @Test
    public void shouldArrayReductionValueMore() {
        list.setArr(new int[]{3, 4, 56, 2, 4});
        list.arrayReduction(13);
        Assert.assertArrayEquals(new int[]{3, 4, 56, 2, 4}, list.getArr());
    }

    @Test
    public void shouldArrayReductionValueLess() {
        list.setArr(new int[]{3, 4, 56, 2, 4});
        list.arrayReduction(-1);
        Assert.assertArrayEquals(new int[]{3, 4, 56, 2, 4}, list.getArr());
    }

    @Test
    public void shouldSortedArray() {
        list.setArr(new int[]{2, 3, 1});
        list.sortedArray();
        Assert.assertArrayEquals(new int[]{1, 2, 3}, list.getArr());
    }

    @Test
    public void shouldConcatenation() {
        list.setArr(new int[]{4, 5, 6, 9, 0, 0, 0});
        list.concatenation(new int[]{1, 2, 3});
        Assert.assertArrayEquals(new int[]{4, 5, 6, 9, 1, 2, 3}, list.getArr());
    }

    @Test
    public void shouldRemoveDuplicates() {
        list.setArr(new int[]{4, 5, 5 ,6, 9, 4});
        list.removeDuplicates();
        Assert.assertArrayEquals(new int[]{4, 5, 6, 9}, list.getArr());
    }

    @Test
    public void shouldFindTheFirstOccurrenceOfTheElementIfElementFound() {
        list.setArr(new int[]{3, 5, 3, 8, 3, 7});
//
        Assert.assertEquals(list.findElement(8), 3);
    }
}
