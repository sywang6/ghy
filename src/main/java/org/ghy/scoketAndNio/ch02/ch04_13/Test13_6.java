package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Test13_6 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_6.txt","rw");
        FileChannel fileChannel = fileA.getChannel();
        fileChannel.lock(1,2,true);
        //共享锁,自己不能写
        fileChannel.write(ByteBuffer.wrap("123456".getBytes()));
    }
}
