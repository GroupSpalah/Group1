package vladyslav_lazin.hw_2023.hw_17_12_23;

import homeworks.vladyslav_lazin.hw_2023.hw_17_12_23.BuggerTask;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuggerTaskTest {
    @Test
    public void buggerGets39AndShouldReturn4() {
        int result = BuggerTask.bugger(39);
        assertEquals(3, result);
    }
    @Test
    public void buggerGets999AndShouldReturn4() {
        int result = BuggerTask.bugger(999);
        assertEquals(4, result);
    }
    @Test
    public void buggerGets4AndShouldReturn0() {
        int result = BuggerTask.bugger(4);
        assertEquals(0, result);
    }
}