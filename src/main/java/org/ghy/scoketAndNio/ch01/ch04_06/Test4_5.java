package org.ghy.scoketAndNio.ch01.ch04_06;

import java.nio.ByteBuffer;
import java.util.Arrays;

//分批次放到缓冲区
public class Test4_5 {
    public static void main(String[] args) {
        byte[] byteArray1 = {1,2,3,4,5,6,7,8,9,10};
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(4);
        int byteArrayCurrentIndex = 0;
        int byteArrayRemaining = 0;
        while(byteArrayCurrentIndex < byteArray1.length){
            byteArrayRemaining = byteArray1.length-byteArrayCurrentIndex;
            int readLength = Math.min(byteArrayRemaining,byteBuffer1.remaining());
            byte[] newByteArray = Arrays.copyOfRange(byteArray1,byteArrayCurrentIndex,byteArrayCurrentIndex+readLength);
            byteBuffer1.put(newByteArray);
            byteBuffer1.flip();
            byte[] getByte = byteBuffer1.array();
            for (int i = 0; i < byteBuffer1.limit(); i++) {
                System.out.print(getByte[i]+" ");
            }
            System.out.println();
            byteArrayCurrentIndex = byteArrayCurrentIndex+readLength;
            byteBuffer1.clear();
        }
    }
}
