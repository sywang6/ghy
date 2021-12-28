package org.ghy.scoketAndNio.ch02.ch04_13;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//提前锁定
public class Test13_19 {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            RandomAccessFile fileA = new RandomAccessFile("f:\\var\\020413_Test13_19.txt","rw");
            FileChannel fileChannel = fileA.getChannel();
            fileChannel.lock(6,2,true);
            fileChannel.write(ByteBuffer.wrap("1".getBytes()));
            fileChannel.write(ByteBuffer.wrap("2".getBytes()));
            fileChannel.write(ByteBuffer.wrap("3".getBytes()));
            fileChannel.write(ByteBuffer.wrap("4".getBytes()));
            fileChannel.write(ByteBuffer.wrap("5".getBytes()));
            fileChannel.write(ByteBuffer.wrap("6".getBytes()));
            //position=6位置已经提前锁定,不能在写入了
            fileChannel.write(ByteBuffer.wrap("7".getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
