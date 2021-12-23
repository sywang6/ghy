package org.ghy.scoketAndNio.ch01.ch04_07;

import java.nio.ByteBuffer;

public class Test6_2 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.position(9);
        System.out.println(byteBuffer.position());
        byteBuffer.put(2,(byte)127);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.get(2));
        System.out.println(byteBuffer.position());
        byteBuffer.rewind();
        byte[] byteArrayOut = new byte[byteBuffer.capacity()];
        byteBuffer.get(byteArrayOut,0,byteArrayOut.length);
        for (int i = 0; i < byteArrayOut.length ;i++) {
            System.out.print(byteArrayOut[i]+" ");
        }
    }
}
