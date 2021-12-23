package org.ghy.scoketAndNio.ch01.ch04_08;

import java.nio.ByteBuffer;

public class Test7  {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        byte[] byteArrayIn2 ={55,66,77};
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(byteArrayIn2);
        byteBuffer1.position(4);
        byteBuffer2.position(1);
        //把byteBuffer2的元素放到byteBuffer1,从byteBuffer1的position位置开始.
        //byteBuffer1和byteBuffer2的position都会改变
        byteBuffer1.put(byteBuffer2);

        System.out.println(byteBuffer1.position());
        System.out.println(byteBuffer2.position());
        byte[] byteArrayOut = byteBuffer1.array();
        for (int i = 0; i < byteArrayOut.length; i++) {
            System.out.print(byteArrayOut[i]+" ");
        }
    }
}
