package org.ghy.scoketAndNio.ch01.ch04_06;

import java.nio.ByteBuffer;

//buffer能装下byteArray
public class Test4_1 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3,4,5};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.position(1);
        byteBuffer.put(byteArray);
        byte[] newByteArray = byteBuffer.array();
        for (int i = 0; i < newByteArray.length; i++) {
            System.out.print(newByteArray[i]);
        }
    }
}
