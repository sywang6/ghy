package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_10 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_10.txt");
        Path path = file.toPath();
        //没有使用强制刷盘选项,效率比较高
        FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW);
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 200; i++) {
            fileChannel.write(ByteBuffer.wrap("a".getBytes()));
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-beginTime);
       fileChannel.close();
    }
}
