package dmytro_k.hw_04_12_22;

import homeworks.dmytro_k.hw_2022.hw_04_12_22.AnimalSounds;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AnimalSoundsTest {

    @Mock
    private AnimalSounds mock;

    @Test
    public void ShouldReturnMoo(){

        Mockito.when(mock.cow()).thenReturn("pi");

        Mockito.when(mock.cow()).thenCallRealMethod();

        Assert.assertEquals("pi", mock.cow());
    }
}
