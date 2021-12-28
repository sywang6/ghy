package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_2 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_2.txt");
        Path path = file.toPath();
        //f:\var\020420_OpenMethmodParam_2.txt文件一开始不存在,运行之后就会创建
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE,StandardOpenOption.WRITE);
        fileChannel.close();
    }
}
