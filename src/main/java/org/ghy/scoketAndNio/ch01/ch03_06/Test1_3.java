package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;

//缓冲区的position不能为负数
public class Test1_3 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        try {
            byteBuffer.position(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
