package homeworks.sergii_khvostov.hw_2022.hw_18_12_22.computer;

/*Создать класс Компьютер со свойствами: Частота процессора (в МГц),
количество ядер, объем памяти (в МБ), объем жесткого диска (в ГБ).
Определить два виртуальных метода: «Стоимость», возвращающую
примерную расчетную стоимость компьютера, рассчитываемую по
формуле: Частота процессора * количество ядер / 100 + количество
памяти / 80 + объем жесткого диска / 20 и логический метод «Пригодность»,
возвращающий истину (true), если частота процессора не менее
2000 МГц, количество ядер не менее 2, объем памяти не менее 2048 МБ,
и объем жесткого диска не менее 320 Гб. Определить также метод
«Информация», который возвращает строку, содержащую информацию
о компьютере: частоту процессора, количество ядер, объем памяти,
объем жесткого диска, стоимость и пригодность для наших нужд.
Создать также класс наследник Ноутбук, с дополнительным свойством:
Продолжительность автономной работы (в минутах) и переопределить
методы: метод «Стоимость» возвращает число,
равное стоимости обычного компьютера
+ количество минут автономной работы / 10, а метод
«Пригодность» возвращает истину, тогда когда и ноутбук пригоден как
обычный компьютер, и Продолжительность автономной работы не
меньше 60 минут. В главной программе (либо по нажатию на кнопку)
создать обычный компьютер и ноутбук и вывести информацию о них.*/

public class Computer {
    private int cpuFrequency;
    private int amountCore;
    private int volumeMemory;
    private int volumeHdd;

    public Computer(int cpuFrequency, int amountCore,
                    int volumeMemory, int volumeHdd) {
        this.cpuFrequency = cpuFrequency;
        this.amountCore = amountCore;
        this.volumeMemory = volumeMemory;
        this.volumeHdd = volumeHdd;
    }

    public int getCpuFrequency() {
        return cpuFrequency;
    }

    public int getAmountCore() {
        return amountCore;
    }

    public int getVolumeMemory() {
        return volumeMemory;
    }

    public int getVolumeHdd() {
        return volumeHdd;
    }

    public int price() {
        return getCpuFrequency() * getAmountCore() / 100 +
                getVolumeMemory() / 80 + getVolumeHdd() / 20;

    }

    public boolean suitability() {
        boolean result = false;

        if (getCpuFrequency() >= 2000 && getAmountCore() >= 2
                && getVolumeMemory() >= 2048
                && getVolumeHdd() >= 320) {
            result = true;
        }
        return result;
    }

    public String info() {
        return "CPU frequency: " + getCpuFrequency() + "\n" +
                "Amount core: " + getAmountCore() + "\n" +
                "Volume memory: " + getVolumeMemory() + "\n" +
                "Volume HDD: " + getVolumeHdd() + "\n" +
                "Price: " + price() + "\n" +
                "Suitability: " + suitability();
    }


}
