package dmytro_m.hw_04_12_22;

import homeworks.dmytro_m.hw_2022.hw_04_12_2022.Calculator1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestCalculator1Mockito {

    private Calculator1 calc = Mockito.mock(Calculator1.class);

    @Mock
    private Calculator1 mock;

    @Spy
    private Calculator1 spy;

    @Test
    public void shouldReturnSum() {

        Mockito.when(mock.random1()).thenReturn(10);
        Mockito.when(mock.sum(5)).thenCallRealMethod();

        Assert.assertEquals(15, mock.sum(5));

    }

    @Test
    public void shouldReturnMinus() {

        Mockito.when(mock.random2()).thenReturn(5);
        Mockito.when(mock.minus(ArgumentMatchers.anyInt())).thenCallRealMethod();

        Assert.assertEquals(50, mock.minus(55));
    }

    @Test
    public void shouldReturnDelenie() {

        Mockito.when(spy.random1()).thenReturn(10);
        Assert.assertEquals(1, spy.del(10));

        Mockito.verify(spy, Mockito.times(1)).random1();
        Mockito.verify(spy, Mockito.times(1)).del(ArgumentMatchers.anyInt());

        Mockito.verifyNoMoreInteractions(spy);
    }

    @Test
    public void shouldReturnYmnowhnie() {

        Mockito.when(mock.random2()).thenReturn(2);
        Mockito.when(mock.ymn(ArgumentMatchers.anyInt())).thenCallRealMethod();

        Assert.assertEquals(50, mock.ymn(25));
    }



}
