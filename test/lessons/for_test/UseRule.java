package lessons.for_test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class UseRule {

    @Rule
    public SystemOutRule outRule = new SystemOutRule().enableLog();

    @Test
    public void shouldPrintInConsole() {
        Calculator calculator = new Calculator();

        calculator.print();

        String log = outRule.getLog();

//        Assert.assertEquals("Hello world\r\n", log);
        Assert.assertTrue(log.contains("Hello world"));
    }
}
