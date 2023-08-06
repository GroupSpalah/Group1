package lessons;

import java.util.Random;

public class RandomValues {
    public static void main(String[] args) {
        Random random = new Random();

//        int value = random.nextInt(30);//[0;29]
        int value = random.nextInt(21) + 10;//[10;30], nextInt(max - min + 1) + min

        System.out.println(value);
    }
}
