package lessons.for_test;

import org.junit.*;

public class CalculatorTest {

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("Before all tests");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("After all tests");
    }

    @Before
    public void beforeEachTest() {
        System.out.println("Before each test");
    }

    @After
    public void afterEachTest() {
        System.out.println("After each test");
    }

    @Test
    public void shouldReturnSumValues() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(4, 5);

        Assert.assertEquals("Should return 9", 9, sum);
    }

    @Test
//    @Ignore
    public void shouldReturnSumValues1() {
        Calculator calculator = new Calculator();

        int sum = calculator.sum(4, 5);

        Assert.assertEquals("Should return 9", 19, sum);
    }
}
