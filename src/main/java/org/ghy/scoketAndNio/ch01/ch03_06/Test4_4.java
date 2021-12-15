package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;

//如果定义了mark,则在将limit调整为小于该mark的值时,该mark被丢弃
public class Test4_4 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1, 2, 3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        System.out.println("A byteBuffer position="+byteBuffer.position()+" limit="+byteBuffer.limit());
        byteBuffer.position(2);
        byteBuffer.mark();
        System.out.println("B byteBuffer position="+byteBuffer.position()+" limit="+byteBuffer.limit());
        //不仅是mark失效,还会使position变为1
        byteBuffer.limit(1);
        System.out.println("C byteBuffer position="+byteBuffer.position()+" limit="+byteBuffer.limit());
        try {
            byteBuffer.reset();
            System.out.println("D byteBuffer position="+byteBuffer.position()+" limit="+byteBuffer.limit());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
