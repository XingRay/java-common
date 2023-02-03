package com.xingray.java.util;

public class MathUtil {

    /**
     * 将一段范围(min~max)的数字拆分为n等分，获得每等分的差值，并且该差值乘以段数可能会略小于max-min，该差值尽可能取整
     */
    public static double getSplitRange(double min, double max, int n) {
        if (min > max || n < 0) {
            throw new IllegalArgumentException();
        }

        double split = (max - min) / (n * 10);
        return reserveValidNumber(split, 2) * 10;
    }

    /**
     * 保留N位有效数字，不会进行四舍五入，后面的数直接抹去
     */
    public static double reserveValidNumber(double v, int n) {
        //v=242.345 n=2
        //log10=2.xx
        if (v == 0) {
            return 0;
        }
        boolean minus = false;
        if (v < 0) {
            minus = true;
            v = -v;
        }
        double log10 = Math.log10(v);

        //3
        int ceil = (int) Math.ceil(log10);
        //2
        int floor = (int) Math.floor(log10);


        double value = 0;
        for (int i = 0; i < n; i++) {
            double pow = Math.pow(10, floor - i);
            double v1 = ((int) (v / pow)) * pow;
            value += v1;
            v -= v1;
        }

        if (minus) {
            return -value;
        } else {
            return value;
        }
    }
}
