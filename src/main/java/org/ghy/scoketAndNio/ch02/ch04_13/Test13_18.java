package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证lock()方法的参数position和size的含义
public class Test13_18 {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_18.txt","rw");
            FileChannel fileChannel = fileA.getChannel();
            System.out.println("A "+fileChannel.position());
            //共享锁
            fileChannel.lock(3,2,true);
            System.out.println("B "+fileChannel.position());
            fileChannel.write(ByteBuffer.wrap("1".getBytes()));
            System.out.println("C "+fileChannel.position());
            fileChannel.write(ByteBuffer.wrap("2".getBytes()));
            System.out.println("D "+fileChannel.position());
            fileChannel.write(ByteBuffer.wrap("3".getBytes()));
            System.out.println("E "+fileChannel.position());
            //在position=3处写入异常,因为这部分已经锁定
            fileChannel.write(ByteBuffer.wrap("4".getBytes()));
            System.out.println("F "+fileChannel.position());
            fileChannel.write(ByteBuffer.wrap("5".getBytes()));
            System.out.println("G "+fileChannel.position());
            fileChannel.write(ByteBuffer.wrap("6".getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
