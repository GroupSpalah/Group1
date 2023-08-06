package sergii_khvostov.hw_16_10_22;

import homeworks.sergii_khvostov.hw_2022.hw_16_10_2022_array_list.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.IOException;

public class ArrayListTest {
    private ArrayList list = new ArrayList(2);

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Before
    public void cleanArray() {
        list.setArray(new int[2]);
    }

    @Test
    public void shouldAddElementToArrayWithNonZeroValue() throws IOException {
        list.addElement(5);
        list.addElement(6);
        list.addElement(7);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{5, 6, 7, 0});
    }

    @Test
    public void shouldAddElementToArrayWithZeroValue() throws IOException {
        list.addElement(0);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{0, 0});
    }

    @Test
    public void shouldChekIfIndexLessZero() throws IOException {
        list.changeElementByIndex(-1, 1);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{0, 0});
    }

    @Test
    public void shouldChekIfIndexMoreArrayLength() throws IOException {
        list.changeElementByIndex(2, 1);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{0, 0});
    }

    @Test
    public void shouldChekIfValueEqualsZero() throws IOException {
        list.changeElementByIndex(0, 0);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{0, 0});
    }

    @Test
    public void shouldChangeElementByIndex() throws IOException {
        list.changeElementByIndex(0, 1);
        list.changeElementByIndex(1, 2);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{1, 2});
    }

    @Test
    public void shouldDeleteElementByIndex() throws IOException {
        list.addElement(1);
        list.addElement(2);
        list.addElement(3);

        list.deleteElementByIndex(2);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{1, 2, 0});
    }

    @Test
    public void shouldChekIfIndexLessZeroForDelete() throws IOException {
        int[] array = list.getArray();

        list.changeElementByIndex(-1, 1);

        Assert.assertArrayEquals(array, new int[]{0, 0});
    }

    @Test
    public void shouldChekIfIndexMoreArrayLengthForDelete() throws IOException {
        int[] array = list.getArray();

        list.changeElementByIndex(2, 1);

        Assert.assertArrayEquals(array, new int[]{0, 0});
    }

    @Test
    public void shouldIncreasingArrayOnValue() throws IOException {
        list.increasingLengthArray(2);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{0, 0, 0, 0});
    }

    @Test
    public void shouldDecreasingArrayLengthOnValue() throws IOException {
        list.decreaseLengthArray(1);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{0});
    }

    @Test
    public void shouldDecreasingArrayLengthIfValueMoreOrEqualsArrayLength() throws IOException {
        list.decreaseLengthArray(3);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{0, 0});
    }

    @Test
    public void shouldDecresingArrayLenghtIfValueEqualsZero() throws IOException {
        list.decreaseLengthArray(0);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{0, 0});
    }

    @Test
    public void shouldSortArray() throws IOException {
        int[] array = list.getArray();

        list.changeElementByIndex(0, 2);
        list.changeElementByIndex(1, 1);

        list.bubbleSortArray(array);

        Assert.assertArrayEquals(array, new int[]{1, 2});
    }

    @Test
    public void shouldAddArrayToArray() throws IOException {
        int[] arrayTo = new int[]{3, 4};

        list.changeElementByIndex(0, 1);
        list.changeElementByIndex(1, 2);

        list.addArrayToArray(arrayTo);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{1, 2, 3, 4});

    }

    @Test
    public void shouldDeleteDuplicatesInArray() throws IOException {
        list.addElement(1);
        list.addElement(2);
        list.addElement(2);

        list.deleteDuplicates();

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{1, 2, 0});
    }

    @Test
    public void shouldFindIndexFirstElementIfElementFinded() throws IOException {
        list.addElement(1);
        list.addElement(2);

        list.searchIndexFirstElement(2);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{1, 2});
    }

    @Test
    public void shouldFindIndexFirstElementIfElementNotFinded() throws IOException {
        list.addElement(1);
        list.addElement(2);

        list.searchIndexFirstElement(3);

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{1, 2});
    }

    @Test
    public void shouldMixArray() throws IOException {
        list.addElement(1);

        list.mixArray();

        int[] array = list.getArray();

        Assert.assertArrayEquals(array, new int[]{1, 0});
    }

    @Test
    public void shouldPrintElements() throws IOException {
        list.addElement(1);
        list.addElement(2);

        list.printElements();

        String log = outRule.getLog();

        Assert.assertEquals("1\t2\t", log);
    }

    @Test
    public void shouldPrintReversElements() throws IOException {
        list.addElement(1);
        list.addElement(2);

        list.printReversElements();

        String log = outRule.getLog();

        Assert.assertEquals("2\t1\t", log);
    }

    @Test
    public void shouldDisplayMessageIncorrectValueInAddElemets() throws IOException {
        list.addElement(0);

        String log = outRule.getLog();

        Assert.assertEquals("Incorrect value\r\n", log);
    }

    @Test
    public void shouldDisplayMessageIncorrectIndexIfZero() throws IOException {
        list.changeElementByIndex(-1, 1);

        String log = outRule.getLog();

        Assert.assertEquals("Incorrect index\r\n", log);
    }

    @Test
    public void shouldDisplayMessageIncorrectIndexIfMoreLenghtArray() throws IOException {
        list.changeElementByIndex(3, 1);

        String log = outRule.getLog();

        Assert.assertEquals("Incorrect index\r\n", log);
    }

    @Test
    public void shouldDisplayMessageIncorrectValueIfValueEqualsZero() throws IOException {
        list.changeElementByIndex(0, 0);

        String log = outRule.getLog();

        Assert.assertEquals("Incorrect value\r\n", log);
    }

    @Test
    public void shouldDisplayMessageIncorrectIndexIfIndexLessZero() throws IOException {
        list.addElement(1);
        list.addElement(2);

        list.deleteElementByIndex(-1);

        String log = outRule.getLog();

        Assert.assertEquals("Incorrect index\r\n", log);
    }

    @Test
    public void shouldDisplayMessageIncorrectIndexIfIndexMoreLengthArray() throws IOException {
        list.addElement(1);
        list.addElement(2);

        list.deleteElementByIndex(2);

        String log = outRule.getLog();

        Assert.assertEquals("Incorrect index\r\n", log);
    }

    @Test
    public void shouldDisplayMessageIncorrectValueIfValueMoreOrEqualsLengthArray() throws IOException {
        list.addElement(1);
        list.addElement(2);

        list.decreaseLengthArray(2);

        String log = outRule.getLog();

        Assert.assertEquals("Incorrect value\r\n", log);
    }

    @Test
    public void shouldDisplayMessageIncorrectValueIfValueEqualsZeroDecrease() throws IOException {
        list.decreaseLengthArray(0);

        String log = outRule.getLog();

        Assert.assertEquals("Incorrect value\r\n", log);
    }

    @Test
    public void shouldDisplayMessageThereIsntSearchedElementIfThereIsNoElement() throws IOException {
        list.addElement(1);
        list.addElement(2);

        list.searchIndexFirstElement(3);

        String log = outRule.getLog();

        Assert.assertEquals("There isn't searched element\r\n", log);
    }
}
