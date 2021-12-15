package org.ghy.scoketAndNio.ch01.ch04_05;

import java.nio.ByteBuffer;

//put(byte[] src, int offset, int length) 和 get(byte[] dst, int offset, int length)
//也是从缓冲区的当前位置开始操作, 形参的offset指原数组或目标数组的偏移量
public class Test5 {
    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5,6,7,8};
        byte[] byteArrayIn2 = {55,66,77,88};
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.put(byteArrayIn1);
        byteBuffer.position(2);

        byteBuffer.put(byteArrayIn2,1,3);
        System.out.print("A=");
        byte[]  getByte= byteBuffer.array();
        for (int i = 0; i < getByte.length; i++) {
            System.out.print(getByte[i]+" ");
        }
        System.out.println();

        byteBuffer.position(1);
        byte[] byteArrayOut = new byte[byteBuffer.capacity()];

        byteBuffer.get(byteArrayOut,3,4);
        System.out.print("B=");
        for (int i = 0; i < byteArrayOut.length; i++) {
            System.out.print(byteArrayOut[i]+" ");
        }
    }
}
//A=1 2 66 77 88 6 7 8 0 0
//B=0 0 0 2 66 77 88 0 0 0