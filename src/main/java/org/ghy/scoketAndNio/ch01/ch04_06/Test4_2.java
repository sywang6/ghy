package org.ghy.scoketAndNio.ch01.ch04_06;

import java.nio.ByteBuffer;

public class Test4_2 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{3,4,5,6,7,8};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.position(8);
        //buffer已经装不下byteArray了
        byteBuffer.put(byteArray);
    }
}
