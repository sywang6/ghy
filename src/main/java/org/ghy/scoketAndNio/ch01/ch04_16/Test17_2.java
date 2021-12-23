package org.ghy.scoketAndNio.ch01.ch04_16;


import java.nio.ByteBuffer;
import java.nio.IntBuffer;

//ByteBuffer的equals,类型不一样,返回false
public class Test17_2 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5};
        int[] intArrayIn2 = {1,2,3,4,5};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        IntBuffer intBuffer2 = IntBuffer.wrap(intArrayIn2);

        System.out.println("A="+byteArrayIn1.equals(intArrayIn2));
    }
}
