package org.ghy.scoketAndNio.ch01.ch03_14;

import java.nio.ByteBuffer;

//arrayOffset偏移量
public class Test15 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        System.out.println("byteBuffer arrayOffset="+byteBuffer.arrayOffset());
    }
}
