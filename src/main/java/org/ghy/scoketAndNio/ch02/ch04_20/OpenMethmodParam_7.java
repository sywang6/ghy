package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_7 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_7.txt");
        Path path = file.toPath();
        //FileChannel关闭时删除文件,如果没有调用close()方法,则在jvm终止是尝试删除该文件
        FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.CREATE,StandardOpenOption.DELETE_ON_CLOSE);
        fileChannel.write(ByteBuffer.wrap("abcde".getBytes()));
        Thread.sleep(20000);
        //fileChannel.close();
    }
}
