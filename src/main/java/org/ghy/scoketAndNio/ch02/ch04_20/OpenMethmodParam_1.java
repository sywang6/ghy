package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_1 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_1.txt");
        Path path = file.toPath();
        //由于没有f:\var\020420_OpenMethmodParam_1.txt这个文件,导致异常啦!CREATE只是表示创建的意图,并不会实际创建一个文件.必须配合其他操作
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.CREATE);
        fileChannel.close();
    }
}
