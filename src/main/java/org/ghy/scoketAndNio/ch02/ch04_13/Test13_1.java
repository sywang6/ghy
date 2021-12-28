package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_1&2.txt","rw");
        FileChannel fileChannelA = fileA.getChannel();
        System.out.println("A begin");
        //操作系统级别的锁,别的jvm虚拟机也获取不了该通道的锁,可先后运行Test13_1 和Test13_2
        fileChannelA.lock(1,2,false);
        System.out.println("A end");
        Thread.sleep(Integer.MAX_VALUE);
        fileA.close();
        fileChannelA.close();
    }
}
