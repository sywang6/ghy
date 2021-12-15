package org.ghy.scoketAndNio.ch01.ch03_06;

import java.nio.ByteBuffer;

//如果未定义mark,那么调用reset方法将导致抛出InvalidMarkException异常
public class Test5 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[]{1,2,3};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray);
        try {
            byteBuffer.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
