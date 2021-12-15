package org.ghy.scoketAndNio.ch01.ch04_05;

import java.nio.ByteBuffer;

//offset+length>dst.length导致异常
public class Test5_4 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayIn1);
        byte[] byteArrayout = new byte[5];
        //从位置0开始装,即使真的给你7个元素,也装不下呀
        byteBuffer.get(byteArrayout,0,7);

    }
}
