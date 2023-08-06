package homeworks.dmytro_m.hw_2022.hw_18_12_2022.Computer;

public class Computer {
    private int CPUFrequency;
    private int numberOfCores;
    private int memorySize;
    private int hardDiskCapacity;

    public int getCPUFrequency() {
        return CPUFrequency;
    }

    public void setCPUFrequency(int CPUFrequency) {
        this.CPUFrequency = CPUFrequency;
    }

    public int getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(int numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        memorySize = memorySize;
    }

    public int getHardDiskCapacity() {
        return hardDiskCapacity;
    }

    public void setHardDiskCapacity(int hardDiskCapacity) {
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public Computer(int CPUFrequency, int numberOfCores, int memorySize, int hardDiskCapacity) {
        this.CPUFrequency = CPUFrequency;
        this.numberOfCores = numberOfCores;
        this.memorySize = memorySize;
        this.hardDiskCapacity = hardDiskCapacity;
    }

    public Computer() {
    }

    public int returnPrice() {
        return CPUFrequency * numberOfCores / 100 + memorySize / 100 + hardDiskCapacity / 20;
    }

    public boolean suitability() {
        return CPUFrequency >= 2000 && numberOfCores >= 2 && memorySize >= 2048 && hardDiskCapacity >= 320;
    }

    public void print() {
        System.out.println("CPU Frequency: " + CPUFrequency + "\t " +
                "Number of cores: " + numberOfCores + "\t" +
                "Memory size: " + memorySize + "\t" +
                "Hard disk capacity: " + hardDiskCapacity + "\t" +
                "Price" + returnPrice() + "\tSuitability for our needs " + suitability());
    }


}
