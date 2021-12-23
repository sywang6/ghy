package org.ghy.scoketAndNio.ch02.ch04_05;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//验证long write(ByteBuffer[] srcs, int offset, int length)将ByteBuffer的remaining写入通道
public class Test5_2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fosRef = new FileOutputStream(new File("f:\\var\\020405_Test5_2.txt"));
        FileChannel fileChannel = fosRef.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.wrap("abcde".getBytes());
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("12345".getBytes());
        byteBuffer2.position(1);
        byteBuffer2.limit(3);
        ByteBuffer byteBuffer3 = ByteBuffer.wrap("d1e1f1".getBytes());
        byteBuffer3.position(2);
        byteBuffer3.limit(4);
        ByteBuffer[] bufferArray = new ByteBuffer[]{byteBuffer1,byteBuffer2,byteBuffer3};
        fileChannel.write(bufferArray,1,2);
        fileChannel.close();
        fosRef.close();


    }
}
