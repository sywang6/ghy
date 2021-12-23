package org.ghy.scoketAndNio.ch01.ch04_16;


import java.nio.ByteBuffer;

//ByteBuffer的compareTo,依次比较剩余元素的值.compareTo和equals都是remaining元素的个数和值完全相等才相等
public class Test17_6 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {3,4,5};
        byte[] byteArrayIn2 = {1,2,3,4,5,6,7,8,9,10};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArrayIn2);

        byteBuffer1.position(0);
        byteBuffer2.position(2);

        System.out.println("A="+byteBuffer1.compareTo(byteBuffer2));

    }
}
