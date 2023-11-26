package sergii_khvostov.hw_04_12_22;

import homeworks.sergii_khvostov.hw_2022.hw_04_12_22.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

public class CalculatorTest {

    @Mock
    private Calculator mock;

    @Spy
    private Calculator spy;


    @Test
    public void shouldReturnAddValuesMock() {
         mock = Mockito.mock(Calculator.class);

        Mockito.when(mock.getOperandOne()).thenReturn(10);
        Mockito.when(mock.getOperandTwo()).thenReturn(20);
        Mockito.when(mock.add(ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt())).thenCallRealMethod();

        Assert.assertEquals(30, mock.add(10, 20));
    }

    @Test
    public void shouldReturnAddValuesSpy() {
        Mockito.when(spy.getOperandOne()).thenReturn(10);
        Mockito.when(spy.getOperandTwo()).thenReturn(20);

        Assert.assertEquals(30, spy.add(10, 20));

        Mockito.verify(spy, Mockito.times(1)).getOperandOne();
        Mockito.verify(spy, Mockito.times(1)).getOperandTwo();
        Mockito.verify(spy, Mockito.times(1)).
                add(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(spy);
    }

    @Test
    public void shouldReturnSubValuesMock() {
        Calculator mock = Mockito.mock(Calculator.class);

        Mockito.when(mock.getOperandOne()).thenReturn(30);
        Mockito.when(mock.getOperandTwo()).thenReturn(20);
        Mockito.when(mock.sub(ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt())).thenCallRealMethod();

        Assert.assertEquals(10, mock.sub(30, 20));

    }

    @Test
    public void shouldReturnSubValuesSpy() {
        Mockito.when(spy.getOperandOne()).thenReturn(30);
        Mockito.when(spy.getOperandTwo()).thenReturn(20);

        Assert.assertEquals(10, spy.sub(30, 20));

        Mockito.verify(spy, Mockito.times(1)).getOperandOne();
        Mockito.verify(spy, Mockito.times(1)).getOperandTwo();
        Mockito.verify(spy, Mockito.times(1)).
                sub(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(spy);
    }

    @Test
    public void shouldReturnDivValuesMock() {
        Calculator mock = Mockito.mock(Calculator.class);

        Mockito.when(mock.getOperandOne()).thenReturn(30);
        Mockito.when(mock.getOperandTwo()).thenReturn(10);
        Mockito.when(mock.div(ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt())).thenCallRealMethod();

        Assert.assertEquals(3, mock.div(30, 10));

    }

    @Test
    public void shouldReturnDivValuesSpy() {
        Mockito.when(spy.getOperandOne()).thenReturn(30);
        Mockito.when(spy.getOperandTwo()).thenReturn(10);

        Assert.assertEquals(3, spy.div(30, 10));

        Mockito.verify(spy, Mockito.times(1)).getOperandOne();
        Mockito.verify(spy, Mockito.times(1)).getOperandTwo();
        Mockito.verify(spy, Mockito.times(1)).
                div(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(spy);
    }

    @Test
    public void shouldReturnMulValuesMock() {
        Calculator mock = Mockito.mock(Calculator.class);

        Mockito.when(mock.getOperandOne()).thenReturn(5);
        Mockito.when(mock.getOperandTwo()).thenReturn(10);
        Mockito.when(mock.mul(ArgumentMatchers.anyInt(),
                ArgumentMatchers.anyInt())).thenCallRealMethod();

        Assert.assertEquals(50, mock.mul(5, 10));
    }

    @Test
    public void shouldReturnMulValuesSpy() {
        Mockito.when(spy.getOperandOne()).thenReturn(5);
        Mockito.when(spy.getOperandTwo()).thenReturn(10);

        Assert.assertEquals(50, spy.mul(5, 10));

        Mockito.verify(spy, Mockito.times(1)).getOperandOne();
        Mockito.verify(spy, Mockito.times(1)).getOperandTwo();
        Mockito.verify(spy, Mockito.times(1)).
                mul(ArgumentMatchers.anyInt(), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(spy);
    }
}


