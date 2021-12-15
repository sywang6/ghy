package org.ghy.scoketAndNio.ch01.ch04_05;

import java.nio.ByteBuffer;

//length>buffer.remaining导致异常
public class Test5_2 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.position(9);
        //从byteArrayIn1的0位置开始取4个元素依次放到缓冲区从position开始的位置.问题是现在byteBuffer的剩余容量已经放不下4个元素了,可不异常了吗
        byteBuffer.put(byteArrayIn1,0,4);

    }
}
