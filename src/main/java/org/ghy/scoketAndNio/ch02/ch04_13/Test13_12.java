package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证独占锁,自己可以写
public class Test13_12 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_12.txt","rw");
        FileChannel fileChannel = fileA.getChannel();
        fileChannel.lock(1,2,false);
        fileChannel.write(ByteBuffer.wrap("123456".getBytes()));
        fileChannel.close();
        fileChannel.close();
    }
}
