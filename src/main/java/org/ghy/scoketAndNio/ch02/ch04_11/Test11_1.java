package org.ghy.scoketAndNio.ch02.ch04_11;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test11_1 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA =  new RandomAccessFile("f:\\var\\020411_Test11_1_a.txt","rw");
        RandomAccessFile fileB = new RandomAccessFile("f:\\var\\020411_Test11_1_b.txt","rw");
        FileChannel fileChannel1 = fileA.getChannel();
        FileChannel fileChannel2 = fileB.getChannel();
        fileChannel2.position(8);
        //给定的位置大于fileChannel1的大小,不传输任何字节
        fileChannel1.transferTo(1000,4,fileChannel2);
        fileChannel1.close();
        fileChannel2.close();
        fileA.close();
        fileB.close();

    }
}
