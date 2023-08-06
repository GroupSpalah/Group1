package lessons.loops;

public class Task1 {
    public static void main(String[] args) {

        int sum = 0;
        int count = 0;

        for (int i = 0; i < 50; i++) {
            if (i < 20) {
                sum += i;
                ++count;
            }
//            System.out.println(sum);
        }

        System.out.println(sum);
        System.out.println(count);
    }
}

/*
* iter0: i == 0; sum = 0 + 0;
* iter1: i == 1; sum = 0 + 1;
* iter2: i == 2; sum = 1 + 2;
* */
