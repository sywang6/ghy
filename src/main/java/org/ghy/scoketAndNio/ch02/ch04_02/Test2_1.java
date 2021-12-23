package org.ghy.scoketAndNio.ch02.ch04_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//int read(ByteBuffer dst)方法返回值的含义:
//正数:从通道读取的字节数
//0:从通道没有读取任何字节,可能是接受的缓冲区没空间了
//-1: 到达了通道的末尾
public class Test2_1 {
    private static FileInputStream fisRef;
    private static FileChannel fileChannel;

    public static void main(String[] args) throws InterruptedException, IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020402_Test2_1.txt"));
        fileChannel = fisRef.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
        int readLength =  fileChannel.read(byteBuffer);
        System.out.println(readLength);
        readLength =  fileChannel.read(byteBuffer);
        System.out.println(readLength);
        byteBuffer.clear();
        readLength =  fileChannel.read(byteBuffer);
        System.out.println(readLength);
        byteBuffer.clear();
        fileChannel.close();
        fisRef.close();


    }
}
