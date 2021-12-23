package org.ghy.scoketAndNio.ch02.ch04_07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证int write(ByteBuffer src, long position)方法中通道的position不变,如果指定的position大于该文件的当前大小,则该文件
//扩大以容纳新的字节,在以前文件末尾和新写入字节之间的字节值是未指定的
public class Test7_4 {
    private static FileOutputStream fosRef;
    private static FileChannel fileChannel;
    public static void main(String[] args) throws IOException, InterruptedException {
         fosRef = new FileOutputStream(new File("f:\\var\\020407_Test7_4.txt"));
         fileChannel = fosRef.getChannel();
        System.out.println("A position"+fileChannel.position());
        fileChannel.position(3);
        System.out.println("B position"+fileChannel.position());
        fileChannel.write(ByteBuffer.wrap("abcde".getBytes()),0);
        System.out.println("C position"+fileChannel.position());

        fileChannel.close();
        fosRef.close();

    }
}
