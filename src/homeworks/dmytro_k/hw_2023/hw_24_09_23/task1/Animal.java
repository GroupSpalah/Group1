package homeworks.dmytro_k.hw_2023.hw_24_09_23.task1;

/**
 * На животноводческой ферме у нас есть кошки, собаки, коровы и гуси. У всех животных есть вес, идентификатор
 * (не задавать в конструкторе, но чтобы был инкремент),
 * и при взаимодействии с ними они издают звук. Кошка говорит «мяу», собака говорит «гав», гусь говорит «гудок»,
 * корова говорит «муу».
 * Вес указан в граммах.
 * Кошки, собаки и коровы — млекопитающие. Когда они рожают, их вес уменьшается на вес ребенка.
 * <p>
 * Владелец фермы хочет иметь возможность просматривать каждое животное и взаимодействовать с ним,
 * чтобы слышать его звуки.
 */

public abstract class Animal {

    private int weight;
    private int id;
    private static int counterIds = 1;
    protected String voice;
    private AnimalClass aAnimalClass;

    public Animal(int weight, AnimalClass aAnimalClass) {
        this.weight = weight;
        this.aAnimalClass = aAnimalClass;
        this.id = counterIds++;
    }

    public AnimalClass getaAnimalClass() {
        return aAnimalClass;
    }

    public String getVoice() {
        return voice;
    }

    public void interaction() {
        System.out.println(voice);
    }

    public void giveBirth(int babyWeight) {
        if (aAnimalClass == AnimalClass.MAMMALS) {
            weight -= babyWeight;
        }
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" + "id" + id +
                ", weight=" + weight +
                ", voice='" + voice + '\'' +
                ", aClass=" + aAnimalClass +
                '}';
    }
}
