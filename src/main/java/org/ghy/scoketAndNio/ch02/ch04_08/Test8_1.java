package org.ghy.scoketAndNio.ch02.ch04_08;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证read(ByteBuffer dst,long position)方法返回值的意义.从通道的指定位置读取,不修改通道的位置,如果
//给定的位置大于该文件的当前大小,则不读取任何字节
public class Test8_1 {
    private static FileInputStream fisRef;
    private  static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020408_Test8_1.txt"));
        fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        int readLength = fileChannel.read(byteBuffer,2);
        System.out.println(readLength);
        byteBuffer.clear();

        readLength = fileChannel.read(byteBuffer,10);
        System.out.println(readLength);
        byteBuffer.clear();
        fileChannel.close();
        fisRef.close();
    }

}
