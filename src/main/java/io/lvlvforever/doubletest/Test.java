package io.lvlvforever.doubletest;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {

        double c = 0.04;
        double d = 0.05;
        System.err.println(d - c);

        BigDecimal b1 = new BigDecimal("0.04");
        BigDecimal b2 = new BigDecimal("0.05");
        System.err.println(b2.subtract(b1));
    }
}
