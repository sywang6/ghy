package org.ghy.scoketAndNio.ch01.ch04_06;

import java.nio.ByteBuffer;

public class Test4_3 {
    public static void main(String[] args) {
        byte[] byteArray1 = new byte[]{1,2,3,4,5,6,7,8,9,10};
        ByteBuffer byteBuffer = ByteBuffer.wrap(byteArray1);
        byte[] byteArrayNew  = new byte[5];
        //buffer还有足够多的元素,能够满足byteArrayNew的要求
        byteBuffer.get(byteArrayNew);
        for(int i = 0; i <byteArrayNew.length; i++) {
            System.out.println(byteArrayNew[i]);
        }
    }
}
