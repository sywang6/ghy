package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//先运行Test13_7在运行Test13_8,验证共享锁别人不能写
public class Test13_7 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_7.txt","rw");
        FileChannel fileChannel = fileA.getChannel();
        fileChannel.lock(1,2,true);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
