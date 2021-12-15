package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;

//如果定义了mark,则在将position调整为不小于该mark的值时,该mark不丢弃
public class Test4_1 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.position(1);
        byteBuffer.mark();
        System.out.println("bytebuffer在"+byteBuffer.position()+"位置设置mark标记");
        byteBuffer.position(2);
        byteBuffer.reset();
        System.out.println();
        System.out.println("bytebuffer回到"+byteBuffer.position()+"位置");
    }
}
