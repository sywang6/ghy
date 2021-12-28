package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_6 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_6.txt");
        Path path = file.toPath();
        //假设f:\var\020420_OpenMethmodParam_6.txt一开始不存在,连续运行该程序两次,第二次会报错,
        //CREATE_NEW和CREATE都表示新建一个文件,不同的如果文件已经存在CREATE_NEW会报错,而CREATE不会报错
        FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW);
        fileChannel.write(ByteBuffer.wrap("abcde".getBytes()));
        fileChannel.close();
    }
}
