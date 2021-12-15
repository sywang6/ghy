package org.ghy.scoketAndNio.ch01.ch04_05;

import java.nio.ByteBuffer;

//length的值大于buffer.remaining时导致异常
public class Test5_5 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayIn1);
       byteBuffer.position(5);
        byte[] byteArrayout = new byte[500];
        //从位置0开始装,装50个元素,问题是现在buffer里面拢共也没有50个元素呀
        byteBuffer.get(byteArrayout,0,50);

    }
}
