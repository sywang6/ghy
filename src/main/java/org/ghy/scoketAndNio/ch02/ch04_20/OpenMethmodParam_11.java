package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_11 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_11.txt");
        Path path = file.toPath();
        //使用强制刷盘选项SYNC,效率急剧下降
        FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.CREATE
        ,StandardOpenOption.SYNC);
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            fileChannel.write(ByteBuffer.wrap("b".getBytes()));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
       fileChannel.close();
    }
}
