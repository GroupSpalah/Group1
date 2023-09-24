package homeworks.dmytro_k.hw_2023.hw_17_09_23;

/**
 *  На животноводческой ферме у нас есть кошки, собаки, коровы и гуси. У всех животных есть вес, идентификатор
 *  (не задавать в конструкторе, но чтобы был инкремент),
 *   и при взаимодействии с ними они издают звук. Кошка говорит «мяу», собака говорит «гав», гусь говорит «гудок»,
 *   корова говорит «муу».
 *  Вес указан в граммах.
 *  Кошки, собаки и коровы — млекопитающие. Когда они рожают, их вес уменьшается на вес ребенка.
 *
 *  Владелец фермы хочет иметь возможность просматривать каждое животное и взаимодействовать с ним,
 *  чтобы слышать его звуки.*/

public abstract class Animal {

    private int weight;
    private int identifier;
    protected String voice;

    public Animal(int weight, int identifier) {
        this.weight = weight;
        this.identifier = identifier;
    }

    public String getVoice() {
        return voice;
    }

    public void interaction() {
        System.out.println(voice);
    }
}
