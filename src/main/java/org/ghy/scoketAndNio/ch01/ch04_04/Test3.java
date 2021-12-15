package org.ghy.scoketAndNio.ch01.ch04_04;

import java.nio.ByteBuffer;

//put(byte b)和get()都是从当前位置开始,结束后position递增
public class Test3 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(10);
        System.out.println("A1 capacity="+byteBuffer1.capacity()+" limit="+byteBuffer1.limit()+" position="+byteBuffer1.position());
        byteBuffer1.put((byte)125);
        System.out.println("A2 capacity="+byteBuffer1.capacity()+" limit="+byteBuffer1.limit()+" position="+byteBuffer1.position());
        byteBuffer1.put((byte)126);
        System.out.println("A3 capacity="+byteBuffer1.capacity()+" limit="+byteBuffer1.limit()+" position="+byteBuffer1.position());
        byteBuffer1.put((byte)127);
        System.out.println("B capacity="+byteBuffer1.capacity()+" limit="+byteBuffer1.limit()+" position="+byteBuffer1.position());
        byteBuffer1.rewind();
        System.out.println("C capacity="+byteBuffer1.capacity()+" limit="+byteBuffer1.limit()+" position="+byteBuffer1.position());
        System.out.println(byteBuffer1.get());
        System.out.println("D capacity="+byteBuffer1.capacity()+" limit="+byteBuffer1.limit()+" position="+byteBuffer1.position());
        System.out.println(byteBuffer1.get());
        System.out.println("E capacity="+byteBuffer1.capacity()+" limit="+byteBuffer1.limit()+" position="+byteBuffer1.position());
        System.out.println(byteBuffer1.get());
        System.out.println("F capacity="+byteBuffer1.capacity()+" limit="+byteBuffer1.limit()+" position="+byteBuffer1.position());
        System.out.println(byteBuffer1.get());
        byte[] getByteArray = byteBuffer1.array();
        for (int i = 0; i < getByteArray.length;i++) {
            System.out.print(getByteArray[i]+"-");
        }

    }
}
