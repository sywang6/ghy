package org.ghy.scoketAndNio.ch01.ch04_12;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Test13_3 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
        byteBuffer.putInt(123);
        byteBuffer.putInt(456);
        byteBuffer.flip();
        IntBuffer intBuffer = byteBuffer.asIntBuffer();
        System.out.println(intBuffer.get());
        System.out.println(intBuffer.get());

        System.out.println();

        System.out.println("bytebuffer是直接缓冲区,效率比较快:");
        System.out.println(byteBuffer);
        System.out.println("由于bytebuffer是直接的,所以intBuffer也是直接缓冲区了:");
        System.out.println(intBuffer);

    }
}
