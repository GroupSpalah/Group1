package dmytro_k.hw_16_10_22;

import homeworks.dmytro_k.hw_2022.hw_16_10_22.ImitationList;
import org.junit.*;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class ImitationListTest {

    ImitationList list = new ImitationList(6);

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Before
    public void beforeEachTest() {
        System.out.println("New test");
        list.setArray(new int[]{3, 5, 3, 8, 3, 7});
        list.printArrayInDirectOrder();
        System.out.println();
    }

    @After
    public void afterEachTest() {
        list.printArrayInDirectOrder();
        System.out.println("\nEnd test");
        System.out.println("--------");
    }

    @Test
    public void shouldAddElementToArrayNotZero() {

        list.setArray(new int[]{0, 0, 0, 0, 0, 0});

        list.addElement(4);

        list.addElement(1);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{4, 1, 0, 0, 0, 0}, array);
    }

    @Test
    public void shouldNotAddElementToArrayValueIsZero() {

        list.addElement(0);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7}, array);
    }

    @Test
    public void shouldNotAddElementToArrayValueIsZeroWithRule() {

        list.addElement(0);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Incorrect value. Value must not be null"));
    }

    @Test
    public void shouldResize() {

        list.addElement(5);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7, 5, 0, 0, 0, 0, 0}, array);
    }

    @Test
    public void shouldChangeElementByIndex() {

        list.changeElementByIndex(5, 9);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 9}, array);
    }

    @Test
    public void shouldChangeElementByIndexIndexMore() {

        list.changeElementByIndex(20, 9);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7}, array);
    }

    @Test
    public void shouldChangeElementByIndexIndexMoreWithRule() {

        list.changeElementByIndex(20, 9);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Incorrect index"));
    }

    @Test
    public void shouldChangeElementByIndexIndexLess() {

        list.changeElementByIndex(-1, 9);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7}, array);
    }

    @Test
    public void shouldChangeElementByIndexIndexLessWithRule() {

        list.changeElementByIndex(-1, 9);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Incorrect index"));
    }

    @Test
    public void shouldChangeElementByIndexValueIsZeroWithRule() {

        list.changeElementByIndex(2, 0);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Incorrect value"));
    }

    @Test
    public void shouldDeleteElementByIndex() {

        list.deleteElementByIndex(5);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3}, array);
    }

    @Test
    public void shouldDeleteElementByIndexIndexLess() {

        list.deleteElementByIndex(-5);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7}, array);
    }

    @Test
    public void shouldDeleteElementByIndexIndexMore() {

        list.deleteElementByIndex(10);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7}, array);
    }

    @Test
    public void shouldDeleteElementByIndexIndexLessWithRule() {

        list.deleteElementByIndex(-2);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Incorrect index"));
    }

    @Test
    public void shouldDeleteElementByIndexIndexMoreWithRule() {

        list.deleteElementByIndex(8);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Incorrect index"));
    }

    @Test
    public void shouldIncreaseArray() {

        list.increaseArray(2);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7, 0, 0}, array);
    }

    @Test
    public void shouldNotIncreaseArray() {

        list.increaseArray(-8);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7}, array);
    }

    @Test
    public void shouldNotIncreaseArrayWithRule() {

        list.increaseArray(-8);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Incorrect value"));
    }

    @Test
    public void shouldReduceArray() {

        list.reduceArrayTo(4);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8}, array);
    }

    @Test
    public void shouldNotReduceArrayValueMoreWithRule() {

        list.reduceArrayTo(25);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Incorrect value"));
    }

    @Test
    public void shouldNotReduceArrayValueLessWithRule() {

        list.reduceArrayTo(0);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("Incorrect value"));
    }

    @Test
    public void shouldNotReduceArrayValueMore() {

        list.reduceArrayTo(10);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7}, array);
    }

    @Test
    public void shouldNotReduceArrayValueLess() {

        list.reduceArrayTo(-5);

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 7}, array);
    }

    @Test
    public void shouldPrintArrayInDirectOrder() {

        list.printArrayInDirectOrder();

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("3\t5\t3\t8\t3\t7"));
    }

    @Test
    public void shouldPrintArrayInReverseOrder() {

        list.printArrayInReverseOrder();

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("7\t3\t8\t3\t5\t3"));
    }

    @Test
    public void shouldBeSorted() {

        list.bubbleSort();

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 3, 3, 5, 7, 8}, array);
    }

    @Test
    public void shouldDoTheConcatenation() {

        list.setArray(new int[]{3, 5, 3, 8, 3, 0});

        list.concatenation(new int[]{2, 2, 2, 2});

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 3, 8, 3, 2, 2, 2, 2}, array);
    }

    @Test
    public void shouldRemoveDuplicatesInArray() {

        list.removeDuplicates();

        int[] array = list.getArray();

        Assert.assertArrayEquals(new int[]{3, 5, 8, 7}, array);
    }

/*    @Test
    public void shouldFindTheFirstOccurrenceOfTheElementIfElementFound() {

        list.setArray(new int[]{3, 5, 3, 8, 3, 7});

        Assert.assertEquals(list.findElement(8), 3);
    }*/

    @Test
    public void shouldFindTheFirstOccurrenceOfTheElementIfElementFoundWithRule() {

        list.findElement(8);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("\nIndex: 3"));
    }

    @Test
    public void shouldFindTheFirstOccurrenceOfTheElementIfElementNotFoundWithRule() {

        list.findElement(2);

        String log = outRule.getLog();

        Assert.assertTrue(log.contains("\nArray does not contain such element"));
    }
}
