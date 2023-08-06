package lessons.for_test;

import junitparams.Parameters;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(JUnitParamsRunner.class)
public class CalculatorMockito {

    @Mock
    private Calculator mock;

    @Spy
    private Calculator spy;

    @Test
    public void shouldMockMethod() {
        Calculator mock = Mockito.mock(Calculator.class);

        Mockito.when(mock.getRandom()).thenReturn(10);
        Mockito.when(mock.sumRandom(ArgumentMatchers.anyInt())).thenCallRealMethod();

        Assert.assertEquals(15, mock.sumRandom(5));
    }

    @Test
    public void shouldSpyMethod() {

        Mockito.when(spy.getRandom()).thenReturn(10);

        Assert.assertEquals(15, spy.sumRandom(5));

        Mockito.verify(spy, Mockito.times(1)).getRandom();
        Mockito.verify(spy, Mockito.times(1)).sumRandom(ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(spy);
    }

    @Test
    @Parameters({"1|5", "9|2"})
    public void shouldUseDifferentParams(int a, int b) {
        Calculator calculator = new Calculator();

        Assert.assertEquals((a + b), calculator.sum(a, b));
    }
}
