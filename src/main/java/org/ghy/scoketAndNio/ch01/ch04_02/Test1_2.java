package org.ghy.scoketAndNio.ch01.ch04_02;

import java.nio.ByteBuffer;

//直接缓冲区的分配,效率要高
public class Test1_2 {
    public static void main(String[] args) {
       long beginTime =  System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1900000000);//1.7个G左右
        for (int i = 0; i < byteBuffer.capacity(); i++) {
            byteBuffer.put((byte)123);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
    }
}
