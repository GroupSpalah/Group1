package homeworks.vladyslav_lazin.hw_2023.hw_17_09_23;

public abstract class Animal {
    
    static int currentId = 0;
    int id;
    int weight;
    int childWeight;

    public abstract void say();

    public abstract void giveBirth(int childWeight);
}
