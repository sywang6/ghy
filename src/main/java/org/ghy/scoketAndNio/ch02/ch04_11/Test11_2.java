package org.ghy.scoketAndNio.ch02.ch04_11;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class Test11_2 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA =  new RandomAccessFile("f:\\var\\020411_Test11_2_a.txt","rw");
        RandomAccessFile fileB = new RandomAccessFile("f:\\var\\020411_Test11_2_b.txt","rw");
        FileChannel fileChannel1 = fileA.getChannel();
        FileChannel fileChannel2 = fileB.getChannel();
        fileChannel2.position(3);
        //正常传输字节, 从fileChannel1的position=2处开始传,一个传输3个字节.第一个字节传输到fileChannel2=3处, 源通道的position不变
        //目标通道的position增加
        fileChannel1.transferTo(2,3,fileChannel2);
        fileChannel1.close();
        fileChannel2.close();
        fileA.close();
        fileB.close();

    }
}
