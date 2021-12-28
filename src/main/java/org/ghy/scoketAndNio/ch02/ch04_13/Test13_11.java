package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//先运行Test13_10在运行Test13_11,验证共享锁别人可以读
public class Test13_11 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_10.txt","rw");
        FileChannel fileChannel = fileA.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        fileChannel.read(byteBuffer);
        byteBuffer.flip();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.print((char)byteBuffer.get());
        }
    }
}
