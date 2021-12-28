package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

//先运行Test13_26在运行Test13_27,独占锁与独占锁是互斥关系
public class Test13_26 {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_26.txt","rw");
            FileChannel fileChannel = fileA.getChannel();
            System.out.println("Test13_26 begin "+System.currentTimeMillis());
            fileChannel.lock(0,Long.MAX_VALUE,false);
            System.out.println("Test13_26 end"+ System.currentTimeMillis());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
