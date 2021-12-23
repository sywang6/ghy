package org.ghy.scoketAndNio.ch01.ch04_11;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class Test10 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = "我是中国人".getBytes();
        System.out.println(Charset.defaultCharset().name());

        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayIn1);
        System.out.println("byteBuffer="+byteBuffer.getClass().getName());

        CharBuffer charBuffer =  byteBuffer.asCharBuffer();
        System.out.println("charBuffer="+charBuffer.getClass().getName());

        System.out.println("byteBuffer.position="+byteBuffer.position()+"byteBuffer.capacity="+byteBuffer.capacity()+"byteBuffer.limit="+byteBuffer.limit());
        System.out.println("charBuffer.position="+charBuffer.position()+"charBuffer.capacity="+charBuffer.capacity()+"charBuffer.limit="+charBuffer.limit());

        System.out.println(charBuffer.capacity());
        charBuffer.position(0);
        for (int i = 0; i < charBuffer.capacity(); i++) {
            System.out.print(charBuffer.get()+" ");
        }

    }
}
