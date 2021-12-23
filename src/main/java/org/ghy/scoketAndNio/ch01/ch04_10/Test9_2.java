package org.ghy.scoketAndNio.ch01.ch04_10;

import java.nio.ByteBuffer;

public class Test9_2 {
    public static void main(String[] args) {
        byte[] byteArray1 = {1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArray1);
        byteBuffer1.position(5);
        ByteBuffer byteBuffer2 = byteBuffer1.slice();
        //byteBuffer2是由byteBuffer1切片产生, Offset发生了变化
        System.out.println(byteBuffer2.arrayOffset());
    }
}
