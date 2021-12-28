package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_8 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_8.txt");
        Path path = file.toPath();
        //创建一个大文件,不使用SPARSE选项,实际有效内容很少,但文件占用很大的磁盘空间
        FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
        long fileSize = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            fileSize++;
        }
        fileChannel.position(fileSize);
        fileChannel.write(ByteBuffer.wrap("a".getBytes()));
       fileChannel.close();
    }
}
