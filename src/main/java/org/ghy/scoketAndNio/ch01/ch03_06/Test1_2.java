package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;

//缓冲区的limit不能为负数
public class Test1_2 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        try {
            byteBuffer.limit(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
