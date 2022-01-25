package org.zzm.jvmbook.ch06.ch04;

public class FloatDiv {
    public static void main(String[] args) {
        float f = 1.0f/0;
        System.out.println((f+""));
        System.out.println((f+1)+"");
        double d = 1.0d/0;
        System.out.println(d+"");
        System.out.println((d+1)+"");
        int i = 1/0;

    }
}
