package org.ghy.scoketAndNio.ch01.ch03_15;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

//使用List.toArray(T[])转成数组类型
public class Test16 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(new byte[]{'a','b','c'});
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(new byte[]{'x','y','z'});
        ByteBuffer byteBuffer3 = ByteBuffer.wrap(new byte[]{'1','2','3'});
        List<ByteBuffer> list = new ArrayList<>();
        list.add(byteBuffer1);
        list.add(byteBuffer2);
        list.add(byteBuffer3);
        ByteBuffer[] byteBufferArray = new ByteBuffer[list.size()];

        list.toArray(byteBufferArray);

        System.out.println(byteBufferArray.length);
        for (int i = 0; i < byteBufferArray.length; i++) {

            ByteBuffer eachByteBuffer = byteBufferArray[i];
            while (eachByteBuffer.hasRemaining()){
                System.out.print((char)eachByteBuffer.get());
            }
            System.out.println();
        }

    }
}
