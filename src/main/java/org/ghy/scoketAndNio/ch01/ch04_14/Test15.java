package org.ghy.scoketAndNio.ch01.ch04_14;

import java.nio.ByteBuffer;

//只读缓冲区
public class Test15 {
    public static void main(String[] args) {
        byte[] byteArrayIn ={1,2,3,4,5};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn);
        ByteBuffer byteBuffer2 = byteBuffer1.asReadOnlyBuffer();
        System.out.println("bytebuffer1.isReadOnly="+byteBuffer1.isReadOnly());
        System.out.println("bytebuffer2.isReadOnly="+byteBuffer2.isReadOnly());
        byteBuffer2.rewind();
        byteBuffer2.put((byte)123);

    }
}
