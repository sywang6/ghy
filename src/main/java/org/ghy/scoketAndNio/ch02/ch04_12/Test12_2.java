package org.ghy.scoketAndNio.ch02.ch04_12;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test12_2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020412_Test12_2_a.txt","rw");
        RandomAccessFile fileB = new RandomAccessFile("f:\\var\\020412_Test12_2_b.txt","rw");
        FileChannel fileChannelA = fileA.getChannel();
        FileChannel fileChannelB = fileB.getChannel();
        fileChannelB.position(4);
        //正常传输数据
        long readLength = fileChannelA.transferFrom(fileChannelB,3,2);
        System.out.println(readLength);
        fileChannelA.close();
        fileChannelB.close();
        fileA.close();
        fileB.close();
    }
}
