package homeworks.dmytro_m.hw_2022.hw_18_12_2022.Computer;

public class Laptop extends Computer{


    private int batteryLife;

    public int getBatteryLife() {
        return batteryLife;
    }

    public void setBatteryLife(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    public Laptop(int CPUFrequency, int numberOfCores, int memorySize, int hardDiskCapacity, int batteryLife) {
        super(CPUFrequency, numberOfCores, memorySize, hardDiskCapacity);
        this.batteryLife = batteryLife;
    }

    public Laptop(int batteryLife) {
        this.batteryLife = batteryLife;
    }

    @Override
    public int returnPrice() {
        return super.returnPrice() + batteryLife/10;
    }

    @Override
    public boolean suitability() {
        return super.suitability() && batteryLife >= 60;
    }
}
