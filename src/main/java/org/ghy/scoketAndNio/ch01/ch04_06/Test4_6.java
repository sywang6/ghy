package org.ghy.scoketAndNio.ch01.ch04_06;

import java.nio.ByteBuffer;

//分批次从缓存取读取
public class Test4_6 {
    public static void main(String[] args) {
        byte[] byteArray = new byte[] {1,2,3,4,5,6,7,8};
        ByteBuffer buffer = ByteBuffer.wrap(byteArray);
        int copyDataCount = 3;
        while(buffer.hasRemaining()){
            byte[] copyByteArray = new byte[(Math.min(buffer.remaining(),copyDataCount))];
            buffer.get(copyByteArray);
            for (int i = 0; i < copyByteArray.length; i++) {
                System.out.print(copyByteArray[i]+" ");
            }
            System.out.println();
        }
    }
}
