package lessons;

public class BitOperators {
    public static void main(String[] args) {
//        System.out.println("Hello!");
        System.out.println(Integer.toBinaryString(47));//00101111
        System.out.println(Integer.toBinaryString(19));//00010011
//        System.out.println("47 & 19 = " + (47 & 19));    //00000011
//        System.out.println("47 | 19 = " + (47 | 19));    //00111111
        System.out.println("47 << 2 = " + (47 << 2));      //00101111 -> 10111100
        /*
         * 47 * 2(2) = 188
         * */

//        System.out.println((int) Math.pow(2, 7));
//        System.out.println(1 << 7);// 1 * 2(7)

        System.out.println("47 >> 2 = " + (47 >> 2));      //00101111 -> 00001011
        /*
         * 47 / 2(2) = 11
         * */

    }
}
