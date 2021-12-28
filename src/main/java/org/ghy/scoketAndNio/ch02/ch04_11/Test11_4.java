package org.ghy.scoketAndNio.ch02.ch04_11;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test11_4 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA =  new RandomAccessFile("f:\\var\\020411_Test11_4_a.txt","rw");
        RandomAccessFile fileB = new RandomAccessFile("f:\\var\\020411_Test11_4_b.txt","rw");
        FileChannel fileChannel1 = fileA.getChannel();
        FileChannel fileChannel2 = fileB.getChannel();
        System.out.println("A position="+fileChannel2.position());
        //fileChannel1有足够的字节,从position位置开始传输5个字节到fileChannel2
        fileChannel1.transferTo(1,5,fileChannel2);
        System.out.println("B position="+fileChannel2.position());
        fileChannel1.close();
        fileChannel2.close();
        fileA.close();
        fileB.close();

    }
}
