package org.ghy.scoketAndNio.ch01.ch04_06;

import java.nio.ByteBuffer;

//put(byte[] src)的含义
public class Test4 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(10);
        byteBuffer1.put((byte)1);
        byteBuffer1.put((byte)2);
        System.out.println("A="+byteBuffer1.position());
        byteBuffer1.put(byteArray);
        System.out.println("B="+byteBuffer1.position());
        byteBuffer1.flip();
        byteBuffer1.position(3);
        System.out.println("C="+byteBuffer1.position());
        byte[] newArray = new byte[byteBuffer1.remaining()];
        byteBuffer1.get(newArray);
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]+" ");
        }
    }
}
