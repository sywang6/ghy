package org.ghy.scoketAndNio.ch02.ch04_10;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//truncate截取缓存区,将此通道的文件截取为给定大小,给定大小<文件的大小,正常截取文件  给定大小>=文件大小,不修改文件.
//如果通道的positio>截取给定的大小,设置通道的position为给定的大小
public class Test10 {
    public static void main(String[] args) throws IOException {
        ByteBuffer byteBuffer1 = ByteBuffer.wrap("12345678".getBytes());
        FileOutputStream fileOutputStream = new FileOutputStream(new File("f:\\var\\020410_Test10.txt"));
        FileChannel fileChannel =  fileOutputStream.getChannel();
        fileChannel.write(byteBuffer1);
        System.out.println("A size="+fileChannel.size()+" position="+fileChannel.position());
        fileChannel.truncate(3);
        System.out.println("B size="+fileChannel.size()+" position="+fileChannel.position());
        fileChannel.close();
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
