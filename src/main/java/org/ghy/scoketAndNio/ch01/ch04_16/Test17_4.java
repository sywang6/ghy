package org.ghy.scoketAndNio.ch01.ch04_16;


import java.nio.ByteBuffer;

//ByteBuffer的equals,两个buffer的remaining内容完全一样则返回true,否则返回false
public class Test17_4 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {3,4,5};
        byte[] byteArrayIn2 = {1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArrayIn2);
        byteBuffer1.position(0);

        byteBuffer2.position(2);
        byteBuffer2.limit(5);

        System.out.println("A="+byteBuffer1.equals(byteBuffer2));
        System.out.println("AA1 bytebuffer1.remaining()="+byteBuffer1.remaining());
        System.out.println("AA2 bytebuffer2.remaining()="+byteBuffer2.remaining());
        byteBuffer2.put(3,(byte)44);
        System.out.println("B="+byteBuffer1.equals(byteBuffer2));
        System.out.println("BB1 bytebuffer1.remaining()="+byteBuffer1.remaining());
        System.out.println("BB2 bytebuffer2.remaining()="+byteBuffer2.remaining());

    }
}
