package homeworks.dmytro_k.hw_2024.hw_10_03_24;

public class TestThread5 extends Thread {
    @Override
    public void run() {
        FileReader.repeatCounter("I");
    }
}
