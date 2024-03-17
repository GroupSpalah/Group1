package homeworks.dmytro_k.hw_2024.hw_10_03_24;

import java.lang.management.ManagementFactory;

public class TestThread1 extends Thread {
    @Override
    public void run() {
        FileReader.repeatCounter("I");
    }
}
