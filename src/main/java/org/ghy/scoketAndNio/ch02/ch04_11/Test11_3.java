package org.ghy.scoketAndNio.ch02.ch04_11;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test11_3 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA =  new RandomAccessFile("f:\\var\\020411_Test11_3_a.txt","rw");
        RandomAccessFile fileB = new RandomAccessFile("f:\\var\\020411_Test11_3_b.txt","rw");
        FileChannel fileChannel1 = fileA.getChannel();
        FileChannel fileChannel2 = fileB.getChannel();
        System.out.println("A position="+fileChannel2.position());
        //fileChannel1不够1000个字节了,总共传输fileChannel1的size-position个字节
        fileChannel1.transferTo(0,1000,fileChannel2);
        System.out.println("B position="+fileChannel2.position());
        fileChannel1.close();
        fileChannel2.close();
        fileA.close();
        fileB.close();

    }
}
