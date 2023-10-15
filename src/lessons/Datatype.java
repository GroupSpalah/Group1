package lessons;

import java.math.BigDecimal;

public class Datatype {
    public static void main(String[] args) {
//        datatype name = value;
        byte a = 10;//8 bites

        byte a1 = (byte) (a + 6);//byte(8 bits) + int(32 bits) -> 32 bits, downcasting

        int i2 = a;//upcasting

//        byte a2 = a1 + a;

        short s = 26687;//16 bites
        int i = 1235448;//32 bites
        long l = 1000000;//64 bites

//        float f = (float) 12.45;
        float f = 12.45F;//32 bits
        double d = 15D;//64 bits

//        System.out.println("Variable d = " + d);

//        System.out.println(5.0 / 2);
//        System.out.println(5 % 2);

        /*
         * 17 / 2 = 8, ost - 1
         * 8 / 2 = 4, ost - 0
         * */
//        boolean b1 = true;
        boolean b1 = false;

        char c = 'D';

        c = 12453;

        c = '\u00A5';

        System.out.println(c);

    }
}
