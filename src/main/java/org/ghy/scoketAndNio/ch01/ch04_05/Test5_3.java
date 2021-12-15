package org.ghy.scoketAndNio.ch01.ch04_05;

import java.nio.ByteBuffer;

//
public class Test5_3 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7,8,9,10,11,12};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        int getArrayIndex = 0;
        while (getArrayIndex<byteArrayIn1.length){
            //下面的代码就是判断:缓冲区的剩余和数组的剩余谁少
            int readLength = Math.min(byteBuffer.remaining(),byteArrayIn1.length-getArrayIndex);
            byteBuffer.put(byteArrayIn1,getArrayIndex,readLength);
            byteBuffer.flip();
            byte[] getArray = byteBuffer.array();
            for (int i = 0; i < byteBuffer.limit(); i++) {
                System.out.print(getArray[i]+" ");
            }
            getArrayIndex = getArrayIndex+readLength;
            System.out.println();
            byteBuffer.clear();
        }
    }
}
