package org.ghy.scoketAndNio.ch02.ch04_15;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Test14_2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020415_Test14_1.txt","rw");
        FileChannel fileChannel = fileA.getChannel();
        System.out.println("B begin");
        FileLock fileLock = fileChannel.tryLock(0,5,false);
        System.out.println("B end获得了锁 fileLock="+fileLock);
    }
}
