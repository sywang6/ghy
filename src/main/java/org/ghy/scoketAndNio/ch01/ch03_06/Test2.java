package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;

//position不能大于其limit
public class Test2 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        byteBuffer.limit(2);
        try {
            byteBuffer.position(3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
