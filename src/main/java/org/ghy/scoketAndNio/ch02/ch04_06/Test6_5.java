package org.ghy.scoketAndNio.ch02.ch04_06;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long read(ByteBuffer[] dsts, int offset, int length)方法最多从通道读取缓冲区剩余容量的字节数
public class Test6_5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fisRef = new FileInputStream(new File("f:\\var\\020406_Test6_5.txt"));
        FileChannel  fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(2);
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(2);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        System.out.println("A "+fileChannel.position());
        long readLength = fileChannel.read(bufferArray,0,2);
        System.out.println("B "+fileChannel.position()+" readLength="+readLength);
        fileChannel.close();
        fisRef.close();
        byteBuffer1.rewind();
        byteBuffer2.rewind();
        for (int i = 0; i < bufferArray.length; i++) {
            ByteBuffer eachBuffer = bufferArray[i];
            byte[] byteArray = eachBuffer.array();
            for (int j = 0; j < byteArray.length; j++) {
                System.out.print((char)byteArray[j]);
            }
            System.out.println();
        }



    }
}
