package org.onjava8.operators;

public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f; // 16 进制(小写)
        System.out.println(
                "i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2F; // 16 进制(大写)
        System.out.println(
                "i2: " + Integer.toBinaryString(i2));
        int i3 = 0177; // 8 进制(前导0)
        System.out.println(
                "i3-int: " + i3);
        System.out.println(
                "i3: " + Integer.toBinaryString(i3));
        char c = 0xffff; // 最大char 型16 进制值
        System.out.println(
                "c: " + Integer.toBinaryString(c));
        byte b = 0x7f; // 最大byte 型16 进制值01111111;
        System.out.println(
                "b: " + Integer.toBinaryString(b));
        short s = 0x7fff; // 最大short 型16 进制值
        System.out.println(
                "s: " + Integer.toBinaryString(s));
        long n1 = 200L; // long 型后缀
        long n2 = 200l; // long 型后缀(容易与数值1 混淆)
        long n3 = 200;
        // Java 7 二进制字面值常量:
        byte blb = (byte)0b00110101;
        System.out.println(
                "blb: " + Integer.toBinaryString(blb));
        short bls = (short)0B0010111110101111;
        System.out.println(
                "bls: " + Integer.toBinaryString(bls));
        int bli = 0b00101111101011111010111110101111;
        System.out.println(
                "bli: " + Integer.toBinaryString(bli));
        long bll = 0b00101111101011111010111110101111;
        System.out.println(
                "bll: " + Long.toBinaryString(bll));
        float blf = 0b1101;
        System.out.println("blf: " +blf);
        float f1 = 1;
        float f2 = 1F; // float 型后缀
        float f3 = 1f; // float 型后缀
        double d1 = 1d; // double 型后缀
        double d2 = 1D; // double 型后缀
        // (long 型的字面值同样适用于十六进制和8 进制)
    }
}
