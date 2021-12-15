package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

//如果定义了mark,则在将position调整为小于该mark的值时,该mark将被丢弃
public class Test4_2 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.position(2);
        byteBuffer.mark();
        System.out.println("bytebuffer在"+byteBuffer.position()+"位置设置mark标记");
        byteBuffer.position(1);
        try {
            byteBuffer.reset();
            System.out.println();
            System.out.println("bytebuffer回到"+byteBuffer.position()+"位置");
        } catch (InvalidMarkException e) {
            e.printStackTrace();
        }
    }
}
