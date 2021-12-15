package org.ghy.scoketAndNio.ch01.ch04_05;

import java.nio.ByteBuffer;

//分批次取
public class Test5_6 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7,8,9,10,11,12};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArrayIn1);
        byte[] byteArrayout = new byte[5];
        while (byteBuffer.hasRemaining()){
            int readLength = Math.min(byteBuffer.remaining(),byteArrayout.length);
            byteBuffer.get(byteArrayout,0,readLength);
            for (int i = 0; i < readLength; i++) {
                System.out.print(byteArrayout[i]+" ");
            }
            System.out.println();
        }
    }
}
