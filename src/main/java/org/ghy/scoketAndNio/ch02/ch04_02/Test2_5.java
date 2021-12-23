package org.ghy.scoketAndNio.ch02.ch04_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//int read(ByteBuffer dst)方法从通道最大读取缓冲区remaining个字节
public class Test2_5 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("f:\\var\\020402_Test2_5.txt"));
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer  = ByteBuffer.allocate(3);
        System.out.println("A "+fileChannel.position());
        fileChannel.read(byteBuffer);
        System.out.println("B "+fileChannel.position());
        fileChannel.close();
        fileInputStream.close();
        byteBuffer.rewind();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.print((char)byteBuffer.get());
        }
    }
}
