package org.ghy.scoketAndNio.ch01.ch04_18;

import java.nio.ByteBuffer;

//buffer扩容
public class Test20 {

    public static ByteBuffer extendSize(ByteBuffer buffer,int extendSize){
        ByteBuffer newBytebuffer = ByteBuffer.allocate(buffer.capacity()+extendSize);
        newBytebuffer.put(buffer);
        return newBytebuffer;
    }


    public static void main(String[] args) {
        byte[] byteArrayIn1 = {1,2,3,4,5};
        ByteBuffer  byteBuffer1 = ByteBuffer.wrap(byteArrayIn1);
        ByteBuffer byteBuffer2 = extendSize(byteBuffer1,2);
        System.out.println("byteBuffer2 capacity="+byteBuffer2.capacity()+" limit="+byteBuffer2.limit()+" position="+byteBuffer2.position());
        byte[] newArray = byteBuffer2.array();
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i]+" ");
        }
    }
}
