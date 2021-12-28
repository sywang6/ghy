package org.ghy.scoketAndNio.ch02.ch04_12;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test12_4 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020412_Test12_4_a.txt","rw");
        RandomAccessFile fileB = new RandomAccessFile("f:\\var\\020412_Test12_4_b.txt","rw");
        FileChannel fileChannelA = fileA.getChannel();
        FileChannel fileChannelB = fileB.getChannel();
        fileChannelB.position(2);
        //count字节数小于src.remaining,count字节数传输到当前通道的position位置
        long readLength = fileChannelA.transferFrom(fileChannelB,1,2);
        System.out.println(readLength);
        fileChannelA.close();
        fileChannelB.close();
        fileA.close();
        fileB.close();
    }
}
