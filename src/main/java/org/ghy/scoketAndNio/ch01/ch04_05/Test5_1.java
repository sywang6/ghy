package org.ghy.scoketAndNio.ch01.ch04_05;

import java.nio.ByteBuffer;

//offset+length>src.length导致异常
public class Test5_1 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        //从byteArrayIn1的0位置开始取10个元素依次放到缓冲区从position开始的位置.问题是现在byteArrayIn1都没10个元素,可不异常了吗
        byteBuffer.put(byteArrayIn1,0,10);

    }
}
