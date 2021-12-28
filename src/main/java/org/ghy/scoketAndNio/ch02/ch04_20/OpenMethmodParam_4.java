package org.ghy.scoketAndNio.ch02.ch04_20;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenMethmodParam_4 {
    public static void main(String[] args) throws IOException {
        File file = new File("f:\\var\\020420_OpenMethmodParam_4.txt");
        Path path = file.toPath();
        //READ只读,如果文件不存在不会创建
        FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
        byte[] byteArray = new byte[(int)file.length()];
        ByteBuffer buffer = ByteBuffer.wrap(byteArray);
        fileChannel.read(buffer);
        fileChannel.close();
        byteArray = buffer.array();
        for (int i = 0; i < byteArray.length; i++) {
            System.out.print((char)byteArray[i]);
        }
    }
}
