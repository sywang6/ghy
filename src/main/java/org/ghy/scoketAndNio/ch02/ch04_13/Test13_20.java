package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//先运行Test13_20在运行Test13_21,共享锁与共享锁之间是非互斥关系
public class Test13_20 {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_20.txt","rw");
            FileChannel fileChannel = fileA.getChannel();
           fileChannel.lock(0,Long.MAX_VALUE,true);
           Thread.sleep(Integer.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
