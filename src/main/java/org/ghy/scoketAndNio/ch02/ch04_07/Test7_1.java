package org.ghy.scoketAndNio.ch02.ch04_07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证int write(ByteBuffer src, long position)方法是从通道的指定位置开始写入的
public class Test7_1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fosRef = new FileOutputStream(new File("f:\\var\\020407_Test7_1.txt"));
        FileChannel fileChannel = fosRef.getChannel();

        try {
            ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
            fileChannel.write(buffer);
            buffer.rewind();
            fileChannel.write(buffer,2);
            System.out.println("C fileChannel.position()="+fileChannel.position());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileChannel.close();
        fosRef.close();

    }
}
