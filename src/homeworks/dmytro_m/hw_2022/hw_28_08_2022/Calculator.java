package homeworks.dmytro_m.hw_2022.hw_28_08_2022;

public class Calculator {
    public static void main(String[] args) {

//        byte
        byte b1 = 7;
        byte b2 = 3;
        byte sumByte = (byte) (b1 + b2);
        byte minusByte = (byte) (b1 - b2);
        byte multiplyByte = (byte) (b1 * b2);
        byte divisionByte = (byte) (b1 / b2);
        byte remainderByte = (byte) (b1 % b2);
        System.out.println("SumByte = " + sumByte + ". MinusByte = " + minusByte + ". MultiplyByte = " +
                multiplyByte + ". DivisionByte = " + divisionByte + ". RemainderByte = " + remainderByte);

//        short
        short s1 = 23454;
        short s2 = 423;
        short sumShort = (short) (b1 + b2);
        short minusShort = (short) (b1 - b2);
        short multiplyShort = (short) (s1 * s2);
        short divisionShort = (short) (s1 / s2);
        short remainderShort = (short) (s1 % s2);
        System.out.println("SumShort = " + sumShort + ". MinusShort = " + minusShort + ". MultiplyShort = " +
                multiplyShort + ". DivisionShort = " + divisionShort + ". RemainderShort = " + remainderShort);

//        int
        int num1 = 1324513;
        int num2 = 252324;
        int sumInt = num1 + num2;
        int minusInt = num1 - num2;
        int multiplyInt = num1 * num2;
        int divisionInt = num1 / num2;
        int remainderInt = num1 % num2;
        System.out.println("SumInt = " + sumInt + ". MinusInt = " + minusInt + ". MultiplyInt = " +
                multiplyInt + ". DivisionInt = " + divisionInt + ". RemainderInt = " + remainderInt);

//        long
        long l1 = 9321423525L;
        long l2 = 252324111L;
        long sumLong = l1 + l2;
        long minusLong = l1 - l2;
        long multiplyLong = l1 * l2;
        long divisionLong = l1 / l2;
        long remainderLong = l1 % l2;
        System.out.println("SumLong = " + sumLong + ". MinusLong = " + minusLong + ". MultiplyLong = " +
                multiplyLong + ". DivisionLong = " + divisionLong + ". RemainderLong = " + remainderLong);
    }
}
