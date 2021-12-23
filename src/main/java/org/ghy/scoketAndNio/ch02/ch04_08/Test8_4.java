package org.ghy.scoketAndNio.ch02.ch04_08;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证read(ByteBuffer dst,long position)方法从通道最多读取缓冲区容量的字节数
public class Test8_4 {
    private static FileInputStream fisRef;
    private  static FileChannel fileChannel;

    public static void main(String[] args) throws IOException {
        fisRef = new FileInputStream(new File("f:\\var\\020408_Test8_4.txt"));
        fileChannel = fisRef.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(3);
        fileChannel.read(byteBuffer,1);
        fileChannel.close();
        fisRef.close();
        byteBuffer.rewind();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            System.out.print((char)byteBuffer.get());
        }
        fileChannel.close();
        fisRef.close();
    }

}
