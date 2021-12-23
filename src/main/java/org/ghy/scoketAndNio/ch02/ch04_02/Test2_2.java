package org.ghy.scoketAndNio.ch02.ch04_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//int read(ByteBuffer dst)是从通道的当前位置开始读取的
public class Test2_2 {
    private static FileInputStream fisRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws InterruptedException, IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020402_Test2_2.txt"));
        fileChannel = fisRef.getChannel();
        fileChannel.position(2);

        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
         fileChannel.read(byteBuffer);
        byte[] getByteArray =byteBuffer.array();
        for (int i = 0; i < getByteArray.length; i++) {
            System.out.println((char)getByteArray[i]);
        }
        fileChannel.close();
        fisRef.close();


    }
}
