package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

//先运行Test13_22在运行Test13_23,共享锁与独占锁之间是互斥关系
public class Test13_22 {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_22.txt","rw");
            FileChannel fileChannel = fileA.getChannel();
            FileLock lock = fileChannel.lock(0,Long.MAX_VALUE,true);
            Thread.sleep(Integer.MAX_VALUE);
            lock.release();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
