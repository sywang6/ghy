package org.ghy.scoketAndNio.ch02.ch04_06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts, int offset, int length)是从通道的当前位置开始写入的
public class Test6_2 {
    private static FileInputStream fisRef;
    private static FileChannel fileChannel;
    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020406_Test6_2.txt"));
        fileChannel = fisRef.getChannel();
        fileChannel.position(2);

        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] byteBufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        long readLength = fileChannel.read(byteBufferArray,0,2);

        for (int i = 0; i < byteBufferArray.length; i++) {
            ByteBuffer eachByteBuffer = byteBufferArray[i];
            byte[] getByteArray = eachByteBuffer.array();
            for (int j = 0; j < getByteArray.length; j++) {
                System.out.print((char)getByteArray[j]);
            }
            System.out.println();
        }
        fileChannel.close();
        fisRef.close();


    }
}
