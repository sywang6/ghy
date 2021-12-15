package org.ghy.scoketAndNio.ch01.ch03_09;

import java.nio.ByteBuffer;

//还原缓冲区的状态
public class Test8 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.position(2);
        byteBuffer.limit(3);
        byteBuffer.mark();

        byteBuffer.clear();
        System.out.println("byteBuffer position="+byteBuffer.position()+" limit="+byteBuffer.limit());
        try {
            byteBuffer.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
