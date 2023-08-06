package dmytro_k.hw_04_12_22;

import homeworks.dmytro_k.hw_2022.hw_04_12_22.Calculator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)

public class CalculatorTest {

    @Mock
    private Calculator mock;

    @Spy
    private Calculator spy;

    @Test
    public void shouldReturnAmountMock() {

        Mockito.when(mock.getOperandOne()).thenReturn(5);
        Mockito.when(mock.getOperandTwo()).thenReturn(4);

        Mockito.when(mock.sum()).thenCallRealMethod();

        Assert.assertEquals(9, mock.sum());
    }

    @Test
    public void shouldReturnAmountSpy() {

        Mockito.when(spy.getOperandOne()).thenReturn(5);
        Mockito.when(spy.getOperandTwo()).thenReturn(4);

        Assert.assertEquals(9, spy.sum());

        Mockito.verify(spy, Mockito.times(1)).getOperandOne();
        Mockito.verify(spy, Mockito.times(1)).getOperandTwo();
        Mockito.verify(spy, Mockito.times(1)).sum();
        Mockito.verifyNoMoreInteractions(spy);
    }

    @Test
    public void shouldReturnDifferenceMock() {

        Mockito.when(mock.getOperandOne()).thenReturn(5);
        Mockito.when(mock.getOperandTwo()).thenReturn(4);

        Mockito.when(mock.difference()).thenCallRealMethod();

        Assert.assertEquals(1, mock.difference());
    }

    @Test
    public void shouldReturnDifferenceSpy() {

        Mockito.when(spy.getOperandOne()).thenReturn(5);
        Mockito.when(spy.getOperandTwo()).thenReturn(4);

        Assert.assertEquals(1, spy.difference());

        Mockito.verify(spy, Mockito.times(1)).getOperandOne();
        Mockito.verify(spy, Mockito.times(1)).getOperandTwo();
        Mockito.verify(spy, Mockito.times(1)).difference();
        Mockito.verifyNoMoreInteractions(spy);
    }

    @Test
    public void shouldReturnQuotientMock() {

        Mockito.when(mock.getOperandOne()).thenReturn(20);
        Mockito.when(mock.getOperandTwo()).thenReturn(4);

        Mockito.when(mock.division()).thenCallRealMethod();

        Assert.assertEquals(5, mock.division());
    }

    @Test
    public void shouldReturnQuotientSpy() {

        Mockito.when(spy.getOperandOne()).thenReturn(20);
        Mockito.when(spy.getOperandTwo()).thenReturn(4);

        Assert.assertEquals(5, spy.division());

        Mockito.verify(spy, Mockito.times(1)).getOperandOne();
        Mockito.verify(spy, Mockito.times(1)).getOperandTwo();
        Mockito.verify(spy, Mockito.times(1)).division();
        Mockito.verifyNoMoreInteractions(spy);
    }

    @Test
    public void shouldReturnMultiplicationMock() {

        Mockito.when(mock.getOperandOne()).thenReturn(5);
        Mockito.when(mock.getOperandTwo()).thenReturn(4);

        Mockito.when(mock.multiplication()).thenCallRealMethod();

        Assert.assertEquals(20, mock.multiplication());
    }

    @Test
    public void shouldReturnMultiplicationSpy() {

        Mockito.when(spy.getOperandOne()).thenReturn(5);
        Mockito.when(spy.getOperandTwo()).thenReturn(4);

        Assert.assertEquals(20, spy.multiplication());

        Mockito.verify(spy, Mockito.times(1)).getOperandOne();
        Mockito.verify(spy, Mockito.times(1)).getOperandTwo();
        Mockito.verify(spy, Mockito.times(1)).multiplication();
        Mockito.verifyNoMoreInteractions(spy);
    }

    @Test
    public void shouldReturnModuloMock() {

        Mockito.when(mock.getOperandOne()).thenReturn(5);
        Mockito.when(mock.getOperandTwo()).thenReturn(4);

        Mockito.when(mock.modulo()).thenCallRealMethod();

        Assert.assertEquals(1, mock.modulo());
    }

    @Test
    public void shouldReturnModuloSpy() {

        Mockito.when(spy.getOperandOne()).thenReturn(5);
        Mockito.when(spy.getOperandTwo()).thenReturn(4);

        Assert.assertEquals(1, spy.modulo());

        Mockito.verify(spy, Mockito.times(1)).getOperandOne();
        Mockito.verify(spy, Mockito.times(1)).getOperandTwo();
        Mockito.verify(spy, Mockito.times(1)).modulo();
        Mockito.verifyNoMoreInteractions(spy);
    }
}
