package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;
//缓冲区的capacity不能为负数
public class Test1_1 {
    public static void main(String[] args) {
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
