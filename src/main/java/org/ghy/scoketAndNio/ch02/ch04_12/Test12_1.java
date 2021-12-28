package org.ghy.scoketAndNio.ch02.ch04_12;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test12_1 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020412_Test12_1_a.txt","rw");
        RandomAccessFile fileB = new RandomAccessFile("f:\\var\\020412_Test12_1_b.txt","rw");
        FileChannel fileChannelA = fileA.getChannel();
        FileChannel fileChannelB = fileB.getChannel();
        fileChannelB.position(4);
        //从fileChannelB传输到fileChannelA,position位置为调用该方法对象的位置. 明显position=100已经
        //超过了fileChannelA的大小,但对应的文件不会增长
        long readLength = fileChannelA.transferFrom(fileChannelB,100,2);
        System.out.println(readLength);
        fileChannelA.close();
        fileChannelB.close();
        fileA.close();
        fileB.close();
    }
}
