package org.ghy.scoketAndNio.ch02.ch04_19;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Test16_7 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020419_Test16_7.txt");
        RandomAccessFile fileA = new RandomAccessFile(file,"rw");
        FileChannel fileChannel = fileA.getChannel();
        MappedByteBuffer byteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE,0,100);
        //isLoaded()作用是判断byteBuffer是否加载到物理内存(只是一个提示,不百分之百保证返回true就一定加载了,返回false就一定没加载,windows
        // 系统永远返回false)
        System.out.println(byteBuffer+" "+byteBuffer.isLoaded());
        //load()把byteBuffer尽可能的加载到物理内存
        byteBuffer = byteBuffer.load();
        System.out.println(byteBuffer+" "+byteBuffer.isLoaded());
        fileChannel.close();
        fileA.close();

    }
}
