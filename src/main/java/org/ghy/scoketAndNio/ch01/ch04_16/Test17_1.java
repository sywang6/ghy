package org.ghy.scoketAndNio.ch01.ch04_16;


import java.nio.ByteBuffer;

//ByteBuffer的equals,是同一个对象,返回true
public class Test17_1 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        System.out.println("A="+byteArrayIn1.equals(byteArrayIn1));
    }
}
