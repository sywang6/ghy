package org.ghy.scoketAndNio.ch01.ch04_01;

import java.nio.ByteBuffer;

public class Test1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocateDirect(100);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(200);
        System.out.println("byteBuffer1 position="+byteBuffer1.position()+" limit="+byteBuffer1.limit());
        System.out.println("byteBuffer2 position="+byteBuffer1.position()+" limit="+byteBuffer1.limit());

        System.out.println("byteBuffer1="+byteBuffer1+" isDirect="+byteBuffer1.isDirect());
        System.out.println("byteBuffer2="+byteBuffer2+" isDirect="+byteBuffer2.isDirect());
    }
}
