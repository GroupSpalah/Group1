package lessons.learn_class;

public class LearnStatic {
    public static void main(String[] args) {
        GameSoldier soldier1 = new GameSoldier();

//        GameSoldier.countAlive = -5;

        GameSoldier soldier2 = new GameSoldier();

//        System.out.println(GameSoldier.countAlive);

    }
}

class GameSoldier {
    private int age;
    private static int countAlive;

    public int getAge() {
        setCountAlive(10);
        return age;
    }

    public static int getCountAlive() {
//        System.out.println(age);
        return countAlive;
    }

    public static void setCountAlive(int countAlive) {
        GameSoldier.countAlive = countAlive;
    }
}
