package org.ghy.scoketAndNio.ch01.ch03_11;

import java.nio.ByteBuffer;

//是否有底层可读写的数组 数组!=null && !isReadOnly
public class Test12_1 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        byteBuffer.put((byte)1);
        byteBuffer.put((byte)2);
        System.out.println(byteBuffer.hasArray());
    }
}
