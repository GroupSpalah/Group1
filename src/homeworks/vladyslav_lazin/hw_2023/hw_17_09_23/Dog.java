package homeworks.vladyslav_lazin.hw_2023.hw_17_09_23;

public abstract class Dog extends Animal {
    DogBreed dogBreed;
    
    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

    @Override
    public void giveBirth(int childWeight) {

    }
}
