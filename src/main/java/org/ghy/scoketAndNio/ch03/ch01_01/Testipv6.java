package org.ghy.scoketAndNio.ch03.ch01_01;

import java.math.BigDecimal;

public class Testipv6 {
    public static void main(String[] args) {
        double getValue = Math.pow(2,128);
        BigDecimal bigDecimal = new BigDecimal(""+getValue);
        System.out.println(bigDecimal.toString());
    }
}
