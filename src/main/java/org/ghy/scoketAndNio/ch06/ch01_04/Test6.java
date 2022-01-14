package org.ghy.scoketAndNio.ch06.ch01_04;

import java.io.IOException;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

//通道文件当前大小与通道打开状态
public class Test6 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("F:\\var\\060104_Test6.txt");
            AsynchronousFileChannel channel = AsynchronousFileChannel.open(path, StandardOpenOption.WRITE);
            System.out.println("File size="+channel.size());
            System.out.println("A isOpen="+channel.isOpen());
            channel.close();
            System.out.println("B isOpen="+channel.isOpen());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
