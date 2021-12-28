package org.ghy.scoketAndNio.ch02.ch04_15;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Test14_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020415_Test14_1.txt","rw");
        FileChannel fileChannel = fileA.getChannel();
        System.out.println("A begin");
        FileLock fileLock = fileChannel.tryLock(0,5,false);
        System.out.println("A end获得了锁 fileLock="+fileLock);
        Thread.sleep(Integer.MAX_VALUE);
    }
}
