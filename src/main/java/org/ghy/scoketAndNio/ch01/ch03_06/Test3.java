package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;

//limit不能大于其capacity
public class Test3 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        try {
            byteBuffer.limit(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
