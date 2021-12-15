package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;

//当新的limit小于position时,则position的值就调整为新limit的值
public class Test6 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.position(3);
        System.out.println("bytebuffer limit(2)之前的位置:"+byteBuffer.position());
        byteBuffer.limit(2);
        System.out.println("bytebuffer limit(2)之后的位置:"+byteBuffer.position());
    }
}
