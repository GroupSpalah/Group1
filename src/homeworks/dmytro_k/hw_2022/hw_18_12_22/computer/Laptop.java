package homeworks.dmytro_k.hw_2022.hw_18_12_22.computer;

/*Создать также класс наследник Ноутбук, с дополнительным свойством.
Продолжительность автономной работы (в минутах) и переопределить
методы:

метод «Стоимость» возвращает число, равное стоимости обычного
компьютера + количество минут автономной работы / 10,++

а метод «Пригодность» возвращает истину, тогда когда и ноутбук пригоден как
обычный компьютер, и Продолжительность автономной работы не
меньше 60 минут.*/

public class Laptop extends Computer {

    private int batteryLife;

    public Laptop(int frequency, int cores, int memory, int hardDisk, int batteryLife) {
        super(frequency, cores, memory, hardDisk);


        this.batteryLife = batteryLife;
    }

    @Override
    public double price() {

        return super.price() + batteryLife / 10;
    }

    @Override
    public boolean fitness() {

        return super.fitness() && batteryLife >= 60;
    }
}
