package org.ghy.scoketAndNio.ch01.ch03_10;

import java.nio.ByteBuffer;

public class Test11 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.position(2);
        byteBuffer.mark();
        System.out.println("A byteBuffer position="+byteBuffer.position()+" limit="+byteBuffer.limit());
        byteBuffer.flip();
        System.out.println("B byteBuffer position="+byteBuffer.position()+" limit="+byteBuffer.limit());
        try {
            byteBuffer.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
