package org.ghy.scoketAndNio.ch01.ch04_16;


import java.nio.ByteBuffer;
import java.nio.IntBuffer;

//ByteBuffer的equals,两个buffer的remaining不一样,返回false
public class Test17_3 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {3,4,5};
        byte[] byteArrayIn2 = {1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArrayIn2);
        byteBuffer1.position(1);
        byteBuffer2.position(2);

        System.out.println("A="+byteBuffer1.equals(byteBuffer2));
        System.out.println("bytebuffer1.remaining()="+byteBuffer1.remaining());
        System.out.println("bytebuffer2.remaining()="+byteBuffer2.remaining());
    }
}
