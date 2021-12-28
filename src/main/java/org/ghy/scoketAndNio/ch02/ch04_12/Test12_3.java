package org.ghy.scoketAndNio.ch02.ch04_12;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test12_3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020412_Test12_3_a.txt","rw");
        RandomAccessFile fileB = new RandomAccessFile("f:\\var\\020412_Test12_3_b.txt","rw");
        FileChannel fileChannelA = fileA.getChannel();
        FileChannel fileChannelB = fileB.getChannel();
        fileChannelB.position(2);
        //count字节数大于src.remaining,通道的src.remaining字节数传输到当前通道的position位置
        long readLength = fileChannelA.transferFrom(fileChannelB,1,200);
        System.out.println(readLength);
        fileChannelA.close();
        fileChannelB.close();
        fileA.close();
        fileB.close();
    }
}
