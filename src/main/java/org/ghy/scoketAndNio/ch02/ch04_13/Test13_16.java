package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//先运行Test13_16在运行Test13_17,验证独占锁别人不能读
public class Test13_16 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_16.txt","rw");
        FileChannel fileChannel = fileA.getChannel();
        fileChannel.lock(1,2,false);
       Thread.sleep(Integer.MAX_VALUE);
    }
}
