package org.ghy.scoketAndNio.ch01.ch04_06;

import java.nio.ByteBuffer;

public class Test4_4 {
    public static void main(String[] args) {
        byte[] byteArray1 = new byte[]{1,2,3,4,5};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray1);
        byteBuffer.position(3);
        byte[] byteArrayNew  = new byte[3];
        //buffer里面的元素已经不能满足byteArrayNew的需要了
        byteBuffer.get(byteArrayNew);
    }
}
