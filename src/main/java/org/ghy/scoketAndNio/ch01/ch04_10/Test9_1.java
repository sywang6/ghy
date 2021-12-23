package org.ghy.scoketAndNio.ch01.ch04_10;

import java.nio.ByteBuffer;

public class Test9_1 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7,8};
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        byteBuffer1.position(5);
        //slice()切片,切片生成的缓冲区与原缓存区共用同一个数组,只是他们各自的mark,position,limit,capacity不一样.
        //byteBuffer2的offset为byteBuffer1的offset+当前position.  所以offset可以理解为byteBuffer2相对于byteBuffer1的偏移
        ByteBuffer byteBuffer2 = byteBuffer1.slice();
        System.out.println("byteBuffer1 position="+byteBuffer1.position()+" capacity="+byteBuffer1.capacity()+" limit="+byteBuffer1.limit());
        System.out.println("byteBuffer2 position="+byteBuffer2.position()+" capacity="+byteBuffer2.capacity()+" limit="+byteBuffer2.limit());

        //put实际操作的数组下标会在index的基础上加上offset
        byteBuffer2.put(0,(byte)111);

        byte[] byteArray1 = byteBuffer1.array();
        byte[] byteArray2 = byteBuffer2.array();
        for (int i = 0; i < byteArray1.length; i++) {
            System.out.print(byteArray1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < byteArray2.length; i++) {
            System.out.print(byteArray2[i]+" ");
        }
    }
}
