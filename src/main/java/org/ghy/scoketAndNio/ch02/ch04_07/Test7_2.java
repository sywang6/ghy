package org.ghy.scoketAndNio.ch02.ch04_07;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证int write(ByteBuffer src, long position)方法将ByteBuffer的remaining写入通道
public class Test7_2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fosRef = new FileOutputStream(new File("f:\\var\\020407_Test7_2.txt"));
        FileChannel fileChannel = fosRef.getChannel();

        try {
            ByteBuffer buffer1 = ByteBuffer.wrap("abcde".getBytes());
            ByteBuffer buffer2 = ByteBuffer.wrap("12345".getBytes());
            fileChannel.write(buffer1);
            buffer2.position(1);
            buffer2.limit(3);
            fileChannel.write(buffer2,2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileChannel.close();
        fosRef.close();

    }
}
