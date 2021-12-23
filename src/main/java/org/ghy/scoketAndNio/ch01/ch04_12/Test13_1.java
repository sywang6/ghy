package org.ghy.scoketAndNio.ch01.ch04_12;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Test13_1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        System.out.println("A1="+byteBuffer.position());
        //根据特定类型进行索引
        byteBuffer.putInt(123);
        System.out.println("A2="+byteBuffer.position());
        byteBuffer.putInt(456);
        System.out.println("A3="+byteBuffer.position());
        System.out.println();
        IntBuffer intBuffer = IntBuffer.allocate(10);
        System.out.println("B1="+intBuffer.position());
        intBuffer.put(456);
        System.out.println("B2="+intBuffer.position());
        intBuffer.put(789);
        System.out.println("B3="+intBuffer.position());
    }
}
