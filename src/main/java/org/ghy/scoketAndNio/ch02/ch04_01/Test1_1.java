package org.ghy.scoketAndNio.ch02.ch04_01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//int write(ByteBuffer src)是从通道的当前位置开始写入的
public class Test1_1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fosRef = new FileOutputStream(new File("f:\\var\\020401_Test1_1.txt"));
        FileChannel fileChannel =  fosRef.getChannel();

        try {
            ByteBuffer buffer = ByteBuffer.wrap("abcde".getBytes());
            System.out.println("A fileChannel.position="+fileChannel.position());
            System.out.println("write() 1 返回值: "+fileChannel.write(buffer));
            System.out.println("B fileChannel.position="+fileChannel.position());
            fileChannel.position(2);
            //buffer的position也会向前推进
            System.out.println("byteBuffer capacity="+buffer.capacity()+" limit="+buffer.limit()+" position="+buffer.position());
            buffer.rewind();
            System.out.println("write() 2 返回值: "+fileChannel.write(buffer));
            System.out.println("C fileChannel.position="+fileChannel.position());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileChannel.close();
        fosRef.close();

    }
}
