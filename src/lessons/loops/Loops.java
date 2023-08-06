package lessons.loops;

public class Loops {
    public static void main(String[] args) {
        /*
         * for
         * for(foreach)
         * while - loop with precondition
         * do-while - loop with postcondition
         * */

        for (int i = 0; i < 5; ++i) {
//            System.out.println("10 jumps");
        }

        int y = 0;

       /* while (y < 5) {
            System.out.println("10 jumps");
            ++y;
        }*/

        int a = 5;

        do {
            System.out.println("10 jumps");
            ++a;
        } while (a < 5);
    }
}
