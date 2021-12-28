package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test13_5_1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        //020413_Test13_5_1&2
        RandomAccessFile file = new RandomAccessFile("f:\\var\\020413_Test13_5_1&2.txt","rw");
        FileChannel fileChannel = file.getChannel();
        System.out.println("A begin");
        fileChannel.lock(0,2,false);
        System.out.println("A end");
        Thread.sleep(20000);
        fileChannel.close();
        file.close();
    }
}
