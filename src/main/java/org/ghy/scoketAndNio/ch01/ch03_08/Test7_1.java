package org.ghy.scoketAndNio.ch01.ch03_08;

import java.nio.ByteBuffer;

//直接缓冲区
public class Test7_1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        System.out.println(byteBuffer.isDirect());
    }
}
