package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_9 {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_9.txt");
        Path path = file.toPath();
        //创建一个大文件,使用SPARSE选项,按实际有效内容占用存储空间.SPARSE必须搭配CREATE_NEW选项,否则无效
        FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW,StandardOpenOption.SPARSE);
        long fileSize = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            fileSize++;
        }
        fileChannel.position(fileSize);
        fileChannel.write(ByteBuffer.wrap("a".getBytes()));
       fileChannel.close();
    }
}
