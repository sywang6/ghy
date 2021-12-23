package org.ghy.scoketAndNio.ch02.ch04_02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//int read(ByteBuffer dst)方法从通道读取的字节放入缓冲区的remaining空间中
public class Test2_6 {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File("f:\\var\\020402_Test2_6.txt"));
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteBuffer byteBuffer  = ByteBuffer.allocate(100);
        byteBuffer.position(1);
        byteBuffer.limit(3);
        fileChannel.read(byteBuffer);
        fileChannel.close();
        fileInputStream.close();
        byteBuffer.rewind();
        for (int i = 0; i < byteBuffer.limit(); i++) {
            byte eachByte = byteBuffer.get();
            if (eachByte == 0){
                System.out.print("空格");
            }else{
                System.out.print((char)eachByte);
            }

        }
    }
}
