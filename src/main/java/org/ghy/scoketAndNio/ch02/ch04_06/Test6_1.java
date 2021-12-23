package org.ghy.scoketAndNio.ch02.ch04_06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts, int offset, int length)方法返回值的含义
public class Test6_1 {
    private static FileInputStream fisRef;
    private static FileChannel fileChannel;
    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020406_Test6_1.txt"));
        fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        long readLength = fileChannel.read(byteBufferArray,0,2);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();

        readLength = fileChannel.read(byteBufferArray,0,2);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();

        readLength = fileChannel.read(byteBufferArray,0,2);
        System.out.println(readLength);
        byteBuffer1.clear();
        byteBuffer2.clear();

        fileChannel.close();
        fisRef.close();

    }
}
