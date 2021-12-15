package org.ghy.scoketAndNio.ch01.ch03_12;

import java.nio.ByteBuffer;
//判断当前位置与限制之间是否有剩余元素
public class Test13 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.limit(3);
        byteBuffer.position(2);
        System.out.println("bytebuffer.hasRemaining="+byteBuffer.hasRemaining()+" byteBuffer.remaining="+byteBuffer.remaining());
    }
}
