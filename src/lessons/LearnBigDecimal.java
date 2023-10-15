package lessons;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LearnBigDecimal {
    public static void main(String[] args) {
        float f1 = 0.3f;
        float f2 = 0.4f;
        float f3 = f1 + f2;

//        System.out.println((double) f3);

        double d1 = 12.45899;
        double d2 = 12.45721;

        BigDecimal bd1 = new BigDecimal(d1);
        BigDecimal bd2 = new BigDecimal(d2);

        BigDecimal bd3 = bd1.setScale(2, RoundingMode.DOWN);
        BigDecimal bd4 = bd2.setScale(2, RoundingMode.DOWN);

        System.out.println(bd3 == bd4);
        System.out.println(bd3.equals(bd4));

//        System.out.println(bd4.doubleValue());
    }
}
