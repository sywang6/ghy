package org.ghy.scoketAndNio.ch02.ch04_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//int write(ByteBuffer src)方法将ByteBuffer的remaining写入通道
public class Test1_2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fosRef = new FileOutputStream(new File("f:\\var\\020401_Test1_2.txt"));
        FileChannel fileChannel =  fosRef.getChannel();

        try {
            ByteBuffer buffer1 = ByteBuffer.wrap("abcde".getBytes());
            ByteBuffer buffer2 = ByteBuffer.wrap("12345".getBytes());
            fileChannel.write(buffer1);
            buffer2.position(1);
            buffer2.limit(3);
            fileChannel.position(2);
            fileChannel.write(buffer2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileChannel.close();
        fosRef.close();
    }
}
