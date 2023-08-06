package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.computer;

public class Notebook extends Computer {

    private int offlineWork;

    public Notebook(int cpuFrequency, int amountCore, int volumeMemory,
                    int volumeHdd, int offlineWork) {
        super(cpuFrequency, amountCore, volumeMemory, volumeHdd);
        this.offlineWork = offlineWork;
    }

    public int getOfflineWork() {
        return offlineWork;
    }

    @Override
    public int price() {
        return super.price() + getOfflineWork() / 10;
    }

    @Override
    public boolean suitability() {
        return super.suitability() && getOfflineWork() >= 60;
    }
}
