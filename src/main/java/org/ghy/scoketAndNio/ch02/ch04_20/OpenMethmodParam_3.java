package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_3 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_3.txt");
        Path path = file.toPath();
        //APPEND在文件末尾追加写入,如果文件不存在,不会创建
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.APPEND);
        fileChannel.write(ByteBuffer.wrap("123".getBytes()));
        fileChannel.close();
    }
}
